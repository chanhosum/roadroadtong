package com.mountbet.accountservice.entity.key;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

/**
 * @author AnsonChan
 * @since 10/7/2018
 */
@PrimaryKeyClass
public class AccountKey {
    @PrimaryKeyColumn(name = "account_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = DataType.Name.BIGINT)
    private Long accountId;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "AccountKey{" +
                "accountId=" + accountId +
                '}';
    }
}
