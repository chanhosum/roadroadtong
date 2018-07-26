package com.mountbet.accountservice.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class InsertTransactionByAccount {
    private Long accountId;

    private Date date;

    private BigDecimal absoluteExRate;

    private BigDecimal balance;

    private BigDecimal commission;

    private BigDecimal credit;

    private String currency;

    private BigDecimal debit;

    private String description;

    private String origin;

    private Long originId;

    private Long originIdOld;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAbsoluteExRate() {
        return absoluteExRate;
    }

    public void setAbsoluteExRate(BigDecimal absoluteExRate) {
        this.absoluteExRate = absoluteExRate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Long getOriginId() {
        return originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public Long getOriginIdOld() {
        return originIdOld;
    }

    public void setOriginIdOld(Long originIdOld) {
        this.originIdOld = originIdOld;
    }

    @Override
    public String toString() {
        return "InsertTransactionByAccount{" +
                "accountId=" + accountId +
                ", date=" + date +
                ", absoluteExRate=" + absoluteExRate +
                ", balance=" + balance +
                ", commission=" + commission +
                ", credit=" + credit +
                ", currency='" + currency + '\'' +
                ", debit=" + debit +
                ", description='" + description + '\'' +
                ", origin='" + origin + '\'' +
                ", originId=" + originId +
                ", originIdOld=" + originIdOld +
                '}';
    }
}
