package com.mountbet.accountservice.dto;

import com.mountbet.accountservice.constant.MarketBettingType;
import com.mountbet.accountservice.constant.OrderStatus;
import com.mountbet.accountservice.constant.OrderType;
import com.mountbet.accountservice.constant.PersistenceType;
import javafx.geometry.Side;

import java.io.Serializable;
import java.util.Date;

public class CurrentOrderSummary implements Serializable {
    private String betId;

    private String marketId;

    private long selectionId;

    private double handicap;

    private CurrentOrderPriceSize priceSize;

    private Side side;

    private OrderStatus status;

    private PersistenceType persistenceType;

    private OrderType orderType;

    private Date placedDate;

    private Date matchedDate;

    private double averagePriceMatched;

    private double sizeMatched;

    private double sizeRemaining;

    private double sizeLapsed;

    private double sizeCancelled;

    private double sizeVoided;

    private String regulatorAuthCode;

    private String regulatorCode;

    private MarketBettingType bettingType;

    private String customerOrderRef;

    public String getBetId() {
        return betId;
    }

    public void setBetId(String betId) {
        this.betId = betId;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public long getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(long selectionId) {
        this.selectionId = selectionId;
    }

    public double getHandicap() {
        return handicap;
    }

    public void setHandicap(double handicap) {
        this.handicap = handicap;
    }

    public CurrentOrderPriceSize getPriceSize() {
        return priceSize;
    }

    public void setPriceSize(CurrentOrderPriceSize priceSize) {
        this.priceSize = priceSize;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public PersistenceType getPersistenceType() {
        return persistenceType;
    }

    public void setPersistenceType(PersistenceType persistenceType) {
        this.persistenceType = persistenceType;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Date getPlacedDate() {
        return placedDate;
    }

    public void setPlacedDate(Date placedDate) {
        this.placedDate = placedDate;
    }

    public Date getMatchedDate() {
        return matchedDate;
    }

    public void setMatchedDate(Date matchedDate) {
        this.matchedDate = matchedDate;
    }

    public double getAveragePriceMatched() {
        return averagePriceMatched;
    }

    public void setAveragePriceMatched(double averagePriceMatched) {
        this.averagePriceMatched = averagePriceMatched;
    }

    public double getSizeMatched() {
        return sizeMatched;
    }

    public void setSizeMatched(double sizeMatched) {
        this.sizeMatched = sizeMatched;
    }

    public double getSizeRemaining() {
        return sizeRemaining;
    }

    public void setSizeRemaining(double sizeRemaining) {
        this.sizeRemaining = sizeRemaining;
    }

    public double getSizeLapsed() {
        return sizeLapsed;
    }

    public void setSizeLapsed(double sizeLapsed) {
        this.sizeLapsed = sizeLapsed;
    }

    public double getSizeCancelled() {
        return sizeCancelled;
    }

    public void setSizeCancelled(double sizeCancelled) {
        this.sizeCancelled = sizeCancelled;
    }

    public double getSizeVoided() {
        return sizeVoided;
    }

    public void setSizeVoided(double sizeVoided) {
        this.sizeVoided = sizeVoided;
    }

    public String getRegulatorAuthCode() {
        return regulatorAuthCode;
    }

    public void setRegulatorAuthCode(String regulatorAuthCode) {
        this.regulatorAuthCode = regulatorAuthCode;
    }

    public String getRegulatorCode() {
        return regulatorCode;
    }

    public void setRegulatorCode(String regulatorCode) {
        this.regulatorCode = regulatorCode;
    }

    public MarketBettingType getBettingType() {
        return bettingType;
    }

    public void setBettingType(MarketBettingType bettingType) {
        this.bettingType = bettingType;
    }

    public String getCustomerOrderRef() {
        return customerOrderRef;
    }

    public void setCustomerOrderRef(String customerOrderRef) {
        this.customerOrderRef = customerOrderRef;
    }

    @Override
    public String toString() {
        return "CurrentOrderSummary{" +
                "betId='" + betId + '\'' +
                ", marketId='" + marketId + '\'' +
                ", selectionId=" + selectionId +
                ", handicap=" + handicap +
                ", priceSize=" + priceSize +
                ", side=" + side +
                ", status=" + status +
                ", persistenceType=" + persistenceType +
                ", orderType=" + orderType +
                ", placedDate=" + placedDate +
                ", matchedDate=" + matchedDate +
                ", averagePriceMatched=" + averagePriceMatched +
                ", sizeMatched=" + sizeMatched +
                ", sizeRemaining=" + sizeRemaining +
                ", sizeLapsed=" + sizeLapsed +
                ", sizeCancelled=" + sizeCancelled +
                ", sizeVoided=" + sizeVoided +
                ", regulatorAuthCode='" + regulatorAuthCode + '\'' +
                ", regulatorCode='" + regulatorCode + '\'' +
                ", bettingType=" + bettingType +
                ", customerOrderRef='" + customerOrderRef + '\'' +
                '}';
    }
}
