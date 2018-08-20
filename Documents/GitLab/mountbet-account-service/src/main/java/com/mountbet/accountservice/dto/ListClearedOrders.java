package com.mountbet.accountservice.dto;

import com.mountbet.accountservice.constant.BetStatus;
import com.mountbet.accountservice.constant.GroupBy;
import com.mountbet.accountservice.constant.Side;

import java.io.Serializable;
import java.util.Set;

public class ListClearedOrders implements Serializable {
    private BetStatus betStatus;

    private Set<String> eventTypeIds;

    private Set<String> eventIds;

    private Set<String> marketIds;

    private Set<String> betIds;

    private Side side;

    private TimeRange settledDateRange;

    private GroupBy groupBy;

    private boolean includeItemDescription;

    private int fromRecord;

    private int recordCount;

    public BetStatus getBetStatus() {
        return betStatus;
    }

    public void setBetStatus(BetStatus betStatus) {
        this.betStatus = betStatus;
    }

    public Set<String> getEventTypeIds() {
        return eventTypeIds;
    }

    public void setEventTypeIds(Set<String> eventTypeIds) {
        this.eventTypeIds = eventTypeIds;
    }

    public Set<String> getEventIds() {
        return eventIds;
    }

    public void setEventIds(Set<String> eventIds) {
        this.eventIds = eventIds;
    }

    public Set<String> getMarketIds() {
        return marketIds;
    }

    public void setMarketIds(Set<String> marketIds) {
        this.marketIds = marketIds;
    }

    public Set<String> getBetIds() {
        return betIds;
    }

    public void setBetIds(Set<String> betIds) {
        this.betIds = betIds;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public TimeRange getSettledDateRange() {
        return settledDateRange;
    }

    public void setSettledDateRange(TimeRange settledDateRange) {
        this.settledDateRange = settledDateRange;
    }

    public GroupBy getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(GroupBy groupBy) {
        this.groupBy = groupBy;
    }

    public boolean isIncludeItemDescription() {
        return includeItemDescription;
    }

    public void setIncludeItemDescription(boolean includeItemDescription) {
        this.includeItemDescription = includeItemDescription;
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
        return "ListClearedOrders{" +
                "betStatus=" + betStatus +
                ", eventTypeIds=" + eventTypeIds +
                ", eventIds=" + eventIds +
                ", marketIds=" + marketIds +
                ", betIds=" + betIds +
                ", side=" + side +
                ", settledDateRange=" + settledDateRange +
                ", groupBy=" + groupBy +
                ", includeItemDescription=" + includeItemDescription +
                ", fromRecord=" + fromRecord +
                ", recordCount=" + recordCount +
                '}';
    }
}
