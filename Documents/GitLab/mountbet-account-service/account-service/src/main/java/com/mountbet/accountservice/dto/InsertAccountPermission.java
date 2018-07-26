package com.mountbet.accountservice.dto;

public class InsertAccountPermission {

    private Long accountId;

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
