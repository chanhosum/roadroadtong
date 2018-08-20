package com.mountbet.accountservice.dto;

import java.io.Serializable;
import java.util.List;

public class ClearedOrderSummaryReport implements Serializable {
    private List<ClearedOrderSummary> clearedOrders;

    private boolean moreAvailable;

    public List<ClearedOrderSummary> getClearedOrders() {
        return clearedOrders;
    }

    public void setClearedOrders(List<ClearedOrderSummary> clearedOrders) {
        this.clearedOrders = clearedOrders;
    }

    public boolean isMoreAvailable() {
        return moreAvailable;
    }

    public void setMoreAvailable(boolean moreAvailable) {
        this.moreAvailable = moreAvailable;
    }

    @Override
    public String toString() {
        return "ClearedOrderSummaryReport{" +
                "clearedOrders=" + clearedOrders +
                ", moreAvailable=" + moreAvailable +
                '}';
    }
}
