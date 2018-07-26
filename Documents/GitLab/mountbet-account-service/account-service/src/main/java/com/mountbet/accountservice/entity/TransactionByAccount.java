package com.mountbet.accountservice.entity;

import com.datastax.driver.core.DataType;
import com.mountbet.accountservice.entity.key.TransactionByAccountKey;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;

@Table(value = "transaction_by_account")
public class TransactionByAccount {
    @PrimaryKey
    private TransactionByAccountKey key;

    @Column(value = "absolute_ex_rate")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal absoluteExRate;

    @Column(value = "balance")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal balance;

    @Column(value = "commission")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal commission;

    @Column(value = "credit")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal credit;

    @Column(value = "currency")
    @CassandraType(type = DataType.Name.TEXT)
    private String currency;

    @Column(value = "debit")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal debit;

    @Column(value = "description")
    @CassandraType(type = DataType.Name.TEXT)
    private String description;

    @Column(value = "origin")
    @CassandraType(type = DataType.Name.TEXT)
    private String origin;

    @Column(value = "origin_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long originId;

    @Column(value = "origin_id_old")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long originIdOld;

    public TransactionByAccountKey getKey() {
        return key;
    }

    public void setKey(TransactionByAccountKey key) {
        this.key = key;
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
        return "TransactionByAccount{" +
                "key=" + key +
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
