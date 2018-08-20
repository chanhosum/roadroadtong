package com.mountbet.accountservice.entity;

import com.datastax.driver.core.DataType;
import com.mountbet.accountservice.entity.key.NavigationKey;
import com.mountbet.accountservice.entity.udt.RunnerCatalog;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.List;

@Table(value = "navigation")
public class Navigation {
    @PrimaryKey
    private NavigationKey key;

    @Column(value = "competition_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long competitionId;

    @Column(value = "event_type_name")
    @CassandraType(type = DataType.Name.TEXT)
    private String eventTypeName;

    @Column(value = "event_name")
    @CassandraType(type = DataType.Name.TEXT)
    private String eventName;

    @Column(value = "competition_name")
    @CassandraType(type = DataType.Name.TEXT)
    private String competitionName;

    @Column(value = "market_name")
    @CassandraType(type = DataType.Name.TEXT)
    private String marketName;

    @Column(value = "market_type")
    @CassandraType(type = DataType.Name.TEXT)
    private String marketType;

    @Column(value = "market_betting_type")
    @CassandraType(type = DataType.Name.TEXT)
    private String marketBettingType;

    @Column(value = "market_start_time")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date marketStartTime;

    @Column(value = "market_suspend_time")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date marketSuspendTime;

    @Column(value = "market_settle_time")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date marketSettleTime;

    @Column(value = "runners")
    @CassandraType(type = DataType.Name.UDT, userTypeName = "runner_catalog")
    private List<RunnerCatalog> runners;

    public NavigationKey getKey() {
        return key;
    }

    public void setKey(NavigationKey key) {
        this.key = key;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public String getMarketBettingType() {
        return marketBettingType;
    }

    public void setMarketBettingType(String marketBettingType) {
        this.marketBettingType = marketBettingType;
    }

    public Date getMarketStartTime() {
        return marketStartTime;
    }

    public void setMarketStartTime(Date marketStartTime) {
        this.marketStartTime = marketStartTime;
    }

    public Date getMarketSuspendTime() {
        return marketSuspendTime;
    }

    public void setMarketSuspendTime(Date marketSuspendTime) {
        this.marketSuspendTime = marketSuspendTime;
    }

    public Date getMarketSettleTime() {
        return marketSettleTime;
    }

    public void setMarketSettleTime(Date marketSettleTime) {
        this.marketSettleTime = marketSettleTime;
    }

    public List<RunnerCatalog> getRunners() {
        return runners;
    }

    public void setRunners(List<RunnerCatalog> runners) {
        this.runners = runners;
    }

    @Override
    public String toString() {
        return "Navigation{" +
                "key=" + key +
                ", competitionId=" + competitionId +
                ", competitionName='" + competitionName + '\'' +
                ", eventTypeName='" + eventTypeName + '\'' +
                ", eventName='" + eventName + '\'' +
                ", marketName='" + marketName + '\'' +
                ", marketType='" + marketType + '\'' +
                ", marketBettingType='" + marketBettingType + '\'' +
                ", marketStartTime=" + marketStartTime +
                ", marketSuspendTime=" + marketSuspendTime +
                ", marketSettleTime=" + marketSettleTime +
                ", runners=" + runners +
                '}';
    }
}