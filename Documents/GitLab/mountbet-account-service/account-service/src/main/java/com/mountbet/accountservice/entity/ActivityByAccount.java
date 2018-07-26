package com.mountbet.accountservice.entity;

import com.datastax.driver.core.DataType;
import com.mountbet.accountservice.entity.key.AccountKey;
import com.mountbet.accountservice.entity.key.ActivityByAccountKey;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

/**
 * @author AnsonChan
 * @since 11/7/2018
 */
@Table(value = "activity_by_account")
public class ActivityByAccount {
    @PrimaryKey
    private ActivityByAccountKey key;

    @Column(value = "account_country")
    @CassandraType(type = DataType.Name.TEXT)
    private String accountCountry;

    @Column(value = "account_ip")
    @CassandraType(type = DataType.Name.TEXT)
    private String accountIp;

    @Column(value = "date")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date date;

    @Column(value = "description")
    @CassandraType(type = DataType.Name.TEXT)
    private String description;

    @Column(value = "host_name")
    @CassandraType(type = DataType.Name.TEXT)
    private String hostName;

    @Column(value = "orginal_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long orginalId;

    @Column(value = "target_account_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long targetAccountId;

    @Column(value = "user_agent")
    @CassandraType(type = DataType.Name.TEXT)
    private String userAgent;

    public ActivityByAccountKey getKey() {
        return key;
    }

    public void setKey(ActivityByAccountKey key) {
        this.key = key;
    }

    public String getAccountCountry() {
        return accountCountry;
    }

    public void setAccountCountry(String accountCountry) {
        this.accountCountry = accountCountry;
    }

    public String getAccountIp() {
        return accountIp;
    }

    public void setAccountIp(String accountIp) {
        this.accountIp = accountIp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Long getOrginalId() {
        return orginalId;
    }

    public void setOrginalId(Long orginalId) {
        this.orginalId = orginalId;
    }

    public Long getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(Long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        return "ActivityByAccount{" +
                "key=" + key +
                ", accountCountry='" + accountCountry + '\'' +
                ", accountIp='" + accountIp + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", hostName='" + hostName + '\'' +
                ", orginalId=" + orginalId +
                ", targetAccountId=" + targetAccountId +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }
}
