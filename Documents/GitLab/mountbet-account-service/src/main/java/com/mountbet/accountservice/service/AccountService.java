package com.mountbet.accountservice.service;

import com.mountbet.accountservice.client.BetClient;
import com.mountbet.accountservice.client.NavigationClient;
import com.mountbet.accountservice.constant.*;
import com.mountbet.accountservice.dto.*;
import com.mountbet.accountservice.entity.BetByMarket;
import com.mountbet.accountservice.entity.BetByMarketForAccountService;
import com.mountbet.accountservice.entity.Navigation;
import com.mountbet.accountservice.entity.udt.RunnerCatalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;

import static com.mountbet.accountservice.constant.GroupBy.*;
import static com.mountbet.accountservice.constant.OrderBy.BY_PLACE_TIME;
import static com.mountbet.accountservice.constant.OrderProjection.ALL;

/**
 * @author AnsonChan
 * @since 10/7/2018
 * Returns a list of BetByMarket that according to the JSON that user provided.
 * The JSON contains parameters that filter and sort the result BetByMarket list.
 */
@Service
@Transactional
public class AccountService {

    @Autowired
    private BetClient betClient;

    @Autowired
    private NavigationClient navigationClient;

    private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);

    public CurrentOrderSummaryReport listCurrentOrders(ListCurrentOrders listCurrentOrders) {
        //init
        Long accountId = new Long(100);//TODO: Should get the account and select by the account after account is available. Hard code for testing this time.
        boolean moreAvailable = false;

        //No need to list by betIds this time.

        /* The user may not putting values in JSON parameters as all the parameters in this API is not required.
         * If user does not put value in a specific optional parameter, the default value will be used.
         * The below 'if' statement is used for check if the user put values in parameters or not. If not, default values will be use for query.
         */
        if (listCurrentOrders.getOrderProjection() == null) {
            listCurrentOrders.setOrderProjection(ALL);
        }
        if (listCurrentOrders.getOrderBy() == null) {
            listCurrentOrders.setOrderBy(BY_PLACE_TIME);
        }
        if (listCurrentOrders.getRecordCount() == 0) {
            listCurrentOrders.setRecordCount(1000);
        }
        List<BetByMarket> result = new ArrayList<BetByMarket>();
        result = getCurrentOrderList(listCurrentOrders.getMarketIds(), listCurrentOrders.getOrderProjection(), listCurrentOrders.getDateRange(), accountId);
        LOG.debug("result size" + result.size());

        /*
         *Cassandra cannot sort by the non-primary key due to it's design limited.
         *Therefore, sorting in the server-side is needed.
         */
        Collections.sort(result, new Comparator<BetByMarket>() {
            public int compare(BetByMarket o1, BetByMarket o2) {
                switch (listCurrentOrders.getOrderBy()) {
                    case BY_MATCH_TIME:
                        return o1.getMatchedDate().compareTo(o2.getMatchedDate());
                    case BY_PLACE_TIME:
                        return o1.getKey().getPlacedDate().compareTo(o2.getKey().getPlacedDate());
                    case BY_SETTLED_TIME:
                        return o1.getSettledDate().compareTo(o2.getSettledDate());
                    case BY_VOID_TIME:
                        return o1.getCancelledDate().compareTo(o2.getCancelledDate());
                    default:
                        return o1.getKey().getPlacedDate().compareTo(o2.getKey().getPlacedDate());
                }
            }
        });



        /*
         *Find and return a list according to 'fromRecord' and 'recordCount' of the JSON parameters.
         * If not provided, the default 'fromRecord' is 0 and 'recordCount' is 1000.
         * 'fromRecord' means the starting index of the whole result list.
         * 'recordCount' means how many record wanted to return.
         * The below code is for find and return the result within the range of 'fromRecord' and 'recordCount'.
         */
        List<BetByMarket> betByMarketListInRange = new ArrayList<>();
        if (result.size() > (listCurrentOrders.getRecordCount() + listCurrentOrders.getFromRecord())) {
            moreAvailable = true;
        }
        ListIterator<BetByMarket> betByMarketListIterator = result.listIterator(listCurrentOrders.getFromRecord());
        int count = 0;
        while (betByMarketListIterator.hasNext()) {
            if (count == listCurrentOrders.getRecordCount()) {
                break;
            }
            betByMarketListInRange.add(betByMarketListIterator.next());
            count++;
        }

        LOG.debug("moreAvailable: " + moreAvailable);
        CurrentOrderSummaryReport currentOrderSummaryReport = new CurrentOrderSummaryReport();
        List<CurrentOrderSummary> currentOrderSummaryList = new ArrayList<>();
        LOG.debug("betByMarketListInRange:" + betByMarketListInRange);
        for (BetByMarket betByMarket : betByMarketListInRange) {
            CurrentOrderSummary currentOrderSummary = new CurrentOrderSummary();
            currentOrderSummary.setBetId(betByMarket.getKey().getBetId().toString());
            currentOrderSummary.setMarketId(betByMarket.getKey().getMarketId());
            currentOrderSummary.setSelectionId(betByMarket.getKey().getSelectionId());
            currentOrderSummary.setHandicap(betByMarket.getHandicap().doubleValue());

            CurrentOrderPriceSize currentOrderPriceSize = new CurrentOrderPriceSize();
            currentOrderPriceSize.setPrice(betByMarket.getPrice().doubleValue());
            currentOrderPriceSize.setSize(betByMarket.getSize().doubleValue());

            currentOrderSummary.setPriceSize(currentOrderPriceSize);
            currentOrderSummary.setSide(betByMarket.getKey().getSide());
            currentOrderSummary.setStatus(betByMarket.getSizeMatched().compareTo(BigDecimal.ZERO) > 0 && betByMarket.getSizePlaced() != betByMarket.getSizeMatched() ? OrderStatus.EXECUTABLE : OrderStatus.EXECUTION_COMPLETE);
            currentOrderSummary.setPersistenceType(betByMarket.getPersistenceType());
            currentOrderSummary.setOrderType(null);//unknown column
            currentOrderSummary.setPlacedDate(betByMarket.getKey().getPlacedDate());
            currentOrderSummary.setMatchedDate(betByMarket.getMatchedDate());
            if (betByMarket.getSizeRemaining() == null) {
                currentOrderSummary.setSizeRemaining(0);
            } else {
                currentOrderSummary.setSizeRemaining(betByMarket.getSizeRemaining().doubleValue());
            }
            if (betByMarket.getSizeLapsed() == null) {
                currentOrderSummary.setSizeLapsed(0);
            } else {
                currentOrderSummary.setSizeLapsed(betByMarket.getSizeLapsed().doubleValue());
            }
            if (betByMarket.getSizeCancelled() == null) {
                currentOrderSummary.setSizeCancelled(0);
            } else {
                currentOrderSummary.setSizeCancelled(betByMarket.getSizeCancelled().doubleValue());
            }
            if (betByMarket.getSizeVoided() == null) {
                currentOrderSummary.setSizeVoided(0);
            } else {
                currentOrderSummary.setSizeVoided(betByMarket.getSizeVoided().doubleValue());
            }
            if (betByMarket.getSizeMatched() == null) {
                currentOrderSummary.setSizeMatched(0);
            } else {
                currentOrderSummary.setSizeMatched(betByMarket.getSizeMatched().doubleValue());
            }
            if (betByMarket.getAverageSizeMatched() == null) {
                currentOrderSummary.setAveragePriceMatched(0);
            } else {
                currentOrderSummary.setAveragePriceMatched(Math.round(betByMarket.getAverageSizeMatched().doubleValue() * 100.0) / 100.0);
            }
            currentOrderSummary.setRegulatorAuthCode(null);//unknown column
            currentOrderSummary.setRegulatorCode(null);//unknown column
            currentOrderSummary.setCustomerOrderRef(null);//unknown column

            currentOrderSummaryList.add(currentOrderSummary);
        }
        currentOrderSummaryReport.setCurrentOrders(currentOrderSummaryList);
        currentOrderSummaryReport.setMoreAvailable(moreAvailable);

        LOG.debug("fromRecord" + listCurrentOrders.getFromRecord());
        LOG.debug("recordCount" + listCurrentOrders.getRecordCount());
        LOG.debug("currentOrderSummaryList size:" + currentOrderSummaryList.size());
        return currentOrderSummaryReport;
    }

    public ClearedOrderSummaryReport listClearedOrders(ListClearedOrders listClearedOrders) {
        RestTemplate rt = new RestTemplate();

        Long accountId = new Long(100);//TODO: Should get the account and select by the account after account is available. Hard code for testing this time.
        boolean moreAvailable = false;

        //The default value of the parameters will be used if the JSON does not insert values in each parameters
        if (listClearedOrders.getSettledDateRange() == null) {
            listClearedOrders.setSettledDateRange(new TimeRange());
        }
        /*If the JSON does not declare the "From" date of the requested time range, the default "From" date will be assigned.
         *The default "From" date will be the last 90 days.
         * The above code is for assigning the value of the day value of 90 days before from today.
         */
        if (listClearedOrders.getSettledDateRange().getFrom() == null) {
            Date today = new Date();
            Calendar cal = new GregorianCalendar();
            cal.setTime(today);
            cal.add(Calendar.DAY_OF_MONTH, -90);//-360 for testing
            Date today90 = cal.getTime();
            TimeRange timeRange = listClearedOrders.getSettledDateRange();
            timeRange.setFrom(today90);
            listClearedOrders.setSettledDateRange(timeRange);
        }
        if (listClearedOrders.getGroupBy() == null) {
            listClearedOrders.setGroupBy(BET);
        }
        if (listClearedOrders.getRecordCount() == 0) {
            listClearedOrders.setRecordCount(1000);
        }

        List<Long> resultList = new ArrayList<Long>();
        resultList = getClearedOrderList(
                listClearedOrders.getBetStatus(),
                accountId,
                listClearedOrders.getGroupBy(),
                listClearedOrders.getEventTypeIds(),
                listClearedOrders.getEventIds(),
                listClearedOrders.getMarketIds(),
                listClearedOrders.getBetIds(),
                listClearedOrders.getSettledDateRange()
        );
        LOG.debug("resultList: " + resultList);
        List<BetByMarketForAccountService> result = new ArrayList<>();
        ResponseEntity<BetByMarketForAccountService[]> responseEntity;
        switch (listClearedOrders.getGroupBy()) {
            case BET:
                responseEntity = betClient.getPastBetByBetId(resultList);
                break;
            case SIDE:
                responseEntity = betClient.getPastBetBySelectionId(resultList);
                break;
            case EVENT:
                responseEntity = betClient.getPastBetByEventId(resultList);
                break;
            case MARKET:
                responseEntity = betClient.getPastBetByMarketId(resultList);
                break;
            case EVENT_TYPE:
                responseEntity = betClient.getPastBetByEventTypeId(resultList);
                break;
            default:
                responseEntity = betClient.getPastBetByBetId(resultList);
        }
        result = Arrays.asList(responseEntity.getBody());
        Collections.sort(result, new Comparator<BetByMarketForAccountService>() {
            public int compare(BetByMarketForAccountService o1, BetByMarketForAccountService o2) {
                return o1.getSettledDate().compareTo(o2.getSettledDate());
            }
        });


        List<BetByMarketForAccountService> betByMarketListInRange = new ArrayList<>();
        if (result.size() > (listClearedOrders.getRecordCount() + listClearedOrders.getFromRecord())) {
            moreAvailable = true;
        }
        ListIterator<BetByMarketForAccountService> betByMarketListIterator = result.listIterator(listClearedOrders.getFromRecord());
        int count = 0;
        while (betByMarketListIterator.hasNext()) {
            if (count == listClearedOrders.getRecordCount()) {
                break;
            }
            betByMarketListInRange.add(betByMarketListIterator.next());
            count++;
        }

        LOG.debug("moreAvailable: " + moreAvailable);
        ClearedOrderSummaryReport clearedOrderSummaryReport = new ClearedOrderSummaryReport();
        List<ClearedOrderSummary> clearedOrderSummaryList = new ArrayList<>();
        for (BetByMarketForAccountService betByMarket : betByMarketListInRange) {
            ClearedOrderSummary clearedOrderSummary = new ClearedOrderSummary();

            Navigation navigation = navigationClient.getMarket(betByMarket.getKey().getMarketId());
            clearedOrderSummary.setEventTypeId(betByMarket.getKey().getEventTypeId().toString());
            ClearedOrderSummaryItemDescription itemDescription = new ClearedOrderSummaryItemDescription();
            itemDescription.setEventTypeDesc(navigation.getEventTypeName());
            itemDescription.setMarketStartTime(navigation.getMarketStartTime());
            clearedOrderSummary.setSettledDate(betByMarket.getSettledDate());
            if (listClearedOrders.getGroupBy() == BET) {
                clearedOrderSummary.setBetCount(1);
            } else {
                clearedOrderSummary.setBetCount(betByMarket.getBetCount());
            }
            clearedOrderSummary.setSizeCancelled(betByMarket.getSizeCancelled().doubleValue());
            clearedOrderSummary.setCustomerOrderRef(String.valueOf(betByMarket.getKey().getAccountId()));

            /*For different groupBy level, the different parameters will be available for this grouping level or lower.
             *The parameters that out of the if statement means it available at the highest level(EVENT_TYPE).
             *The grouping level is based on follow: EVENT_TYPE > EVENT > MARKET > SIDE > BET
             */

            //EVENT groupBy level or lower
            if (listClearedOrders.getGroupBy() != EVENT_TYPE) {
                clearedOrderSummary.setEventId(betByMarket.getKey().getEventId().toString());
                itemDescription.setEventDesc(navigation.getEventName());
            }

            //MARKET groupBy level or lower
            if (listClearedOrders.getGroupBy() != EVENT_TYPE || listClearedOrders.getGroupBy() != EVENT) {
                clearedOrderSummary.setMarketId(betByMarket.getKey().getMarketId());
                itemDescription.setMarketDesc(navigation.getMarketName());
                clearedOrderSummary.setPriceReduced(Boolean.FALSE);
                clearedOrderSummary.setHandicap(0.0);
                clearedOrderSummary.setSizeSettled(betByMarket.getSizeVoided().doubleValue());
            }

            //SIDE groupBy level or lower
            if (listClearedOrders.getGroupBy() != EVENT_TYPE || listClearedOrders.getGroupBy() != EVENT || listClearedOrders.getGroupBy() != MARKET) {
                clearedOrderSummary.setSelectionId(betByMarket.getKey().getSelectionId());
                clearedOrderSummary.setHandicap(betByMarket.getHandicap().doubleValue());
                clearedOrderSummary.setSide(betByMarket.getKey().getSide());
                clearedOrderSummary.setPriceRequested(betByMarket.getPrice().doubleValue());
            }

            //BET groupBy level
            if (listClearedOrders.getGroupBy() != EVENT_TYPE || listClearedOrders.getGroupBy() != EVENT || listClearedOrders.getGroupBy() != MARKET || listClearedOrders.getGroupBy() != SIDE) {
                clearedOrderSummary.setBetId(betByMarket.getKey().getBetId().toString());
                clearedOrderSummary.setPlacedDate(betByMarket.getKey().getPlacedDate());
                clearedOrderSummary.setPersistenceType(betByMarket.getPersistenceType());
                clearedOrderSummary.setOrderType(OrderType.LIMIT);
                for (RunnerCatalog runnerCatalog : navigation.getRunners()) {
                    if (runnerCatalog.getSelectionId() == betByMarket.getKey().getSelectionId()) {
                        itemDescription.setRunnerDesc(runnerCatalog.getRunnerName());
                    }
                }
            }

            //MARKET groupBy level or higher
            if (listClearedOrders.getGroupBy() != BET || listClearedOrders.getGroupBy() != SIDE) {
                clearedOrderSummary.setCommission(0);
            }
            clearedOrderSummary.setItemDescription(itemDescription);

            clearedOrderSummaryList.add(clearedOrderSummary);
        }
        clearedOrderSummaryReport.setClearedOrders(clearedOrderSummaryList);
        clearedOrderSummaryReport.setMoreAvailable(moreAvailable);
        LOG.debug("return clearedOrderSummaryReport");
        return clearedOrderSummaryReport;
    }

    /*
     * The query will base on what filter and sort that the JSON required.
     * For example, the JSON may or may not contains 'marketIdsSet'. Different query statement will be used.
     * The JSON may also contains 'timeRange'. The query statement will be different for each situation.
     */
    private List<BetByMarket> getCurrentOrderList(Set<String> marketIdsSet, OrderProjection orderProjection, TimeRange timeRange, Long accountId) {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<BetByMarket[]> responseEntity;
        if (marketIdsSet == null) {
            responseEntity = betClient.getCurrentBetByState(accountId, timeRange, orderProjection);
        } else {
            responseEntity = betClient.getCurrentBetByMarketIdsAndState(marketIdsSet, accountId, timeRange, orderProjection);
        }
        return Arrays.asList(responseEntity.getBody());
    }

    /*The query requires the name of state that will select
     *For different betStatus getting from JSON, different state will be selected.
     */
    private List<Long> getClearedOrderList(BetStatus betStatus, Long accountId, GroupBy groupBy, Set<String> etid, Set<String> eid, Set<String> mid, Set<String> bid, TimeRange timeRange) {
        Set<String> stateSet = new HashSet<>();
        switch (betStatus) {
            case SETTLED:
                stateSet.add("WON");
                stateSet.add("LOST");
                break;
            case VOIDED:
                stateSet.add("VOIDED");
                break;
            case LAPSED:
                stateSet.add("LAPSED");
                break;
            case CANCELLED:
                stateSet.add("CANCELLED");
                break;
        }
        return executeClearedOrderQuery(stateSet, accountId, groupBy, etid, eid, mid, bid, timeRange);
    }

    /* For different situation of the JSON, different query statment will be used.
     * For example, if the JSON only have set of eventId is not null, the query that find by event(getPastBetIdByEventIds()) will be used.
     * Due to the design limit of cassandra, currently only support find by ids and group by under same column. For example, provide marketIdSet only support group by marketId.
     * Provide different set of ids from different column is not support in this time yet.(Example: provide both marketId set and eventId set.)
     */
    private List<Long> executeClearedOrderQuery(Set<String> state, Long accountId, GroupBy groupBy, Set<String> etid, Set<String> eid, Set<String> mid, Set<String> bid, TimeRange timeRange) {
        String selectColumns = "";
        RestTemplate rt = new RestTemplate();
        switch (groupBy) {
            case EVENT_TYPE:
                selectColumns = "event_type_id";
                break;
            case EVENT:
                selectColumns = "event_id";
                break;
            case MARKET:
                selectColumns = "market_id";
                break;
            case SIDE:
                selectColumns = "selection_id";
                break;
            case BET:
                selectColumns = "bet_id";
                break;
        }
        ResponseEntity<Long[]> responseEntity;
        if (etid != null) {
            responseEntity = betClient.getPastBetIdByEventTypeIds(selectColumns, state, etid, accountId, timeRange);
        } else if (eid != null) {
            responseEntity = betClient.getPastBetIdByEventIds(selectColumns, state, eid, accountId, timeRange);
        } else if (mid != null) {
            responseEntity = betClient.getPastBetIdByMarketIds(selectColumns, state, mid, accountId, timeRange);
        } else if (bid != null) {
            responseEntity = betClient.getPastBetIdByBetIds(selectColumns, state, bid, accountId, timeRange);
        } else {
            responseEntity = betClient.getPastBetId(selectColumns, state, accountId, timeRange);
        }
        return Arrays.asList(responseEntity.getBody());
    }

}