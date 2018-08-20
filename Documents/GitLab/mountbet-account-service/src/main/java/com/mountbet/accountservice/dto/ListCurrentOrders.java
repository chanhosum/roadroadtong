package com.mountbet.accountservice.dto;

import com.mountbet.accountservice.constant.OrderBy;
import com.mountbet.accountservice.constant.OrderProjection;
import com.mountbet.accountservice.constant.SortDir;

import java.io.Serializable;
import java.util.Set;

public class ListCurrentOrders  implements Serializable {

    private Set<String> betIds;

    private Set<String> marketIds;

    private OrderProjection orderProjection;

    private TimeRange dateRange;

    private OrderBy orderBy;

    private SortDir sortDir;

    private int fromRecord;

    private int recordCount;

    public Set<String> getBetIds() {
        return betIds;
    }

    public void setBetIds(Set<String> betIds) {
        this.betIds = betIds;
    }

    public Set<String> getMarketIds() {
        return marketIds;
    }

    public void setMarketIds(Set<String> marketIds) {
        this.marketIds = marketIds;
    }

    public OrderProjection getOrderProjection() {
        return orderProjection;
    }

    public void setOrderProjection(OrderProjection orderProjection) {
        this.orderProjection = orderProjection;
    }

    public TimeRange getDateRange() {
        return dateRange;
    }

    public void setDateRange(TimeRange dateRange) {
        this.dateRange = dateRange;
    }

    public OrderBy getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
    }

    public SortDir getSortDir() {
        return sortDir;
    }

    public void setSortDir(SortDir sortDir) {
        this.sortDir = sortDir;
    }

    public int getFromRecord() {
        return fromRecord;
    }

    public void setFromRecord(int fromRecord) {
        this.fromRecord = fromRecord;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    @Override
    public String toString() {
        return "ListCurrentOrders{" +
                "betIds=" + betIds +
                ", marketIds=" + marketIds +
                ", orderProjection=" + orderProjection +
                ", dateRange=" + dateRange +
                ", orderBy=" + orderBy +
                ", sortDir=" + sortDir +
                ", fromRecord=" + fromRecord +
                ", recordCount=" + recordCount +
                '}';
    }
}
