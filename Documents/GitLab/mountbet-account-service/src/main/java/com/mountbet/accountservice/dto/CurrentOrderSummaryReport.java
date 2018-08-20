package com.mountbet.accountservice.dto;

import java.io.Serializable;
import java.util.List;

public class CurrentOrderSummaryReport implements Serializable {

    private List<CurrentOrderSummary> currentOrders;

    private boolean moreAvailable;

    public List<CurrentOrderSummary> getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(List<CurrentOrderSummary> currentOrders) {
        this.currentOrders = currentOrders;
    }

    public boolean isMoreAvailable() {
        return moreAvailable;
    }

    public void setMoreAvailable(boolean moreAvailable) {
        this.moreAvailable = moreAvailable;
    }

    @Override
    public String toString() {
        return "CurrentOrderSummaryReport{" +
                "currentOrders=" + currentOrders +
                ", moreAvailable=" + moreAvailable +
                '}';
    }
}
