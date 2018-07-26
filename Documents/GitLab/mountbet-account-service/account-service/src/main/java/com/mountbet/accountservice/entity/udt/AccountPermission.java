package com.mountbet.accountservice.entity.udt;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("account_permission")
public class AccountPermission {
    @Column(value = "account_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long accountId;

    @Column(value = "permission")
    @CassandraType(type = DataType.Name.TEXT)
    private String permission;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "InsertAccountPermission{" +
                "accountId=" + accountId +
                ", permission='" + permission + '\'' +
                '}';
    }
}
