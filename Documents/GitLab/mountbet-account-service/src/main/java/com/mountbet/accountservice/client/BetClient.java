package com.mountbet.accountservice.client;

import com.mountbet.accountservice.constant.OrderProjection;
import com.mountbet.accountservice.dto.*;
import com.mountbet.accountservice.entity.BetByMarket;
import com.mountbet.accountservice.entity.BetByMarketForAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;

@Component
public class BetClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(BetClient.class);

    @Value("${bet-service.url}")
    private String betServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<BetByMarketForAccountService[]> getPastBetByBetId(List<Long> resultList){
        return restTemplate.postForEntity(betServiceUrl+"/bet/getPastBetByBetId/",resultList,BetByMarketForAccountService[].class);
    }

    public ResponseEntity<BetByMarketForAccountService[]> getPastBetBySelectionId(List<Long> resultList){
        return restTemplate.postForEntity(betServiceUrl+"/bet/getPastBetBySelectionId/",resultList,BetByMarketForAccountService[].class);
    }

    public ResponseEntity<BetByMarketForAccountService[]> getPastBetByEventId(List<Long> resultList){
        return restTemplate.postForEntity(betServiceUrl+"/bet/getPastBetByEventId/",resultList,BetByMarketForAccountService[].class);
    }

    public ResponseEntity<BetByMarketForAccountService[]> getPastBetByMarketId(List<Long> resultList){
        return restTemplate.postForEntity(betServiceUrl+"/bet/getPastBetByMarketId/",resultList,BetByMarketForAccountService[].class);
    }

    public ResponseEntity<BetByMarketForAccountService[]> getPastBetByEventTypeId(List<Long> resultList){
        return restTemplate.postForEntity(betServiceUrl+"/bet/getPastBetByEventTypeId/",resultList,BetByMarketForAccountService[].class);
    }

    public ResponseEntity<BetByMarket[]> getCurrentBetByState(Long accountId, TimeRange timeRange, OrderProjection orderProjection){
        GetCurrentBetByStateDTO getCurrentBetByStateDTO = new GetCurrentBetByStateDTO();
        getCurrentBetByStateDTO.setAccountId(accountId);
        getCurrentBetByStateDTO.setTimeRange(timeRange);
        getCurrentBetByStateDTO.setOrderProjection(orderProjection);
        return restTemplate.postForEntity(betServiceUrl+"/bet/getCurrentBetByState/",getCurrentBetByStateDTO,BetByMarket[].class);
    }

    public ResponseEntity<BetByMarket[]> getCurrentBetByMarketIdsAndState(Set<String> marketIdsSet, Long accountId, TimeRange timeRange, OrderProjection orderProjection){
        GetCurrentBetByMarketIdsAndStateDTO getCurrentBetByMarketIdsAndStateDTO = new GetCurrentBetByMarketIdsAndStateDTO();
        getCurrentBetByMarketIdsAndStateDTO.setMarketIdsSet(marketIdsSet);
        getCurrentBetByMarketIdsAndStateDTO.setAccountId(accountId);
        getCurrentBetByMarketIdsAndStateDTO.setTimeRange(timeRange);
        getCurrentBetByMarketIdsAndStateDTO.setOrderProjection(orderProjection);
        return restTemplate.postForEntity(betServiceUrl+"/bet/getCurrentBetByMarketIdsAndState/",getCurrentBetByMarketIdsAndStateDTO,BetByMarket[].class);
    }

    public ResponseEntity<Long[]> getPastBetIdByEventTypeIds(String selectColumns,Set<String> state,Set<String> etid,Long accountId,TimeRange timeRange){
        GetPastBetIdByEventTypeIdsDTO getPastBetIdByEventTypeIdsDTO = new GetPastBetIdByEventTypeIdsDTO();
        getPastBetIdByEventTypeIdsDTO.setSelectColumns(selectColumns);
        getPastBetIdByEventTypeIdsDTO.setState(state);
        getPastBetIdByEventTypeIdsDTO.setEventTypeIdsSet(etid);
        getPastBetIdByEventTypeIdsDTO.setAccountId(accountId);
        getPastBetIdByEventTypeIdsDTO.setTimeRange(timeRange);
        return restTemplate.postForEntity(betServiceUrl+"/bet/getPastBetIdByEventTypeIds/",getPastBetIdByEventTypeIdsDTO,Long[].class);
    }

    public ResponseEntity<Long[]> getPastBetIdByEventIds(String selectColumns,Set<String> state,Set<String> eid,Long accountId,TimeRange timeRange){
        GetPastBetIdByEventIdsDTO getPastBetIdByEventIdsDTO = new GetPastBetIdByEventIdsDTO();
        getPastBetIdByEventIdsDTO.setSelectColumns(selectColumns);
        getPastBetIdByEventIdsDTO.setState(state);
        getPastBetIdByEventIdsDTO.setEventIdsSet(eid);
        getPastBetIdByEventIdsDTO.setAccountId(accountId);
        getPastBetIdByEventIdsDTO.setTimeRange(timeRange);
        return restTemplate.postForEntity(betServiceUrl+"/bet/getPastBetIdByEventIds/",getPastBetIdByEventIdsDTO,Long[].class);
    }

    public ResponseEntity<Long[]> getPastBetIdByMarketIds(String selectColumns,Set<String> state,Set<String> mid,Long accountId,TimeRange timeRange){
        GetPastBetIdByMarketIdsDTO getPastBetIdByMarketIdsDTO = new GetPastBetIdByMarketIdsDTO();
        getPastBetIdByMarketIdsDTO.setSelectColumns(selectColumns);
        getPastBetIdByMarketIdsDTO.setState(state);
        getPastBetIdByMarketIdsDTO.setMarketIdsSet(mid);
        getPastBetIdByMarketIdsDTO.setAccountId(accountId);
        getPastBetIdByMarketIdsDTO.setTimeRange(timeRange);
        return restTemplate.postForEntity(betServiceUrl + "/bet/getPastBetIdByMarketIds/", getPastBetIdByMarketIdsDTO, Long[].class);
    }

    public ResponseEntity<Long[]> getPastBetIdByBetIds(String selectColumns,Set<String> state,Set<String> bid,Long accountId,TimeRange timeRange){
        GetPastBetIdByBetIdsDTO getPastBetIdByBetIdsDTO = new GetPastBetIdByBetIdsDTO();
        getPastBetIdByBetIdsDTO.setSelectColumns(selectColumns);
        getPastBetIdByBetIdsDTO.setState(state);
        getPastBetIdByBetIdsDTO.setBetIdsSet(bid);
        getPastBetIdByBetIdsDTO.setAccountId(accountId);
        getPastBetIdByBetIdsDTO.setTimeRange(timeRange);
        return restTemplate.postForEntity(betServiceUrl+"/bet/getPastBetIdByBetIds/",getPastBetIdByBetIdsDTO,Long[].class);
    }

    public ResponseEntity<Long[]> getPastBetId(String selectColumns,Set<String> state, Long accountId,TimeRange timeRange){
        GetPastBetIdDTO getPastBetIdDTO = new GetPastBetIdDTO();
        getPastBetIdDTO.setSelectColumns(selectColumns);
        getPastBetIdDTO.setState(state);
        getPastBetIdDTO.setAccountId(accountId);
        getPastBetIdDTO.setTimeRange(timeRange);
        return restTemplate.postForEntity(betServiceUrl+"/bet/getPastBetId/",getPastBetIdDTO,Long[].class);
    }
}
