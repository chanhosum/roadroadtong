package com.mountbet.betservice.dto;

import com.mountbet.betservice.constant.AccountType;

import java.math.BigDecimal;

public class BetInsertPlaceOrderRiskDetail {

    private Long accountId;


    private BigDecimal value;

    private AccountType type;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BetInsertPlaceOrderRiskDetail{" +
                "accountId=" + accountId +
                ", value=" + value +
                ", type=" + type +
                '}';
    }
}
