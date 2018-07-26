package com.mountbet.accountservice.dto;

import java.util.ArrayList;
import java.util.List;

public class InsertTransactionByAccountList {
    private List<InsertTransactionByAccount> insertAccountList = new ArrayList<>();

    public List<InsertTransactionByAccount> getInsertAccountList() {
        return insertAccountList;
    }

    public void setInsertAccountList(List<InsertTransactionByAccount> insertAccountList) {
        this.insertAccountList = insertAccountList;
    }

    @Override
    public String toString() {
        return "InsertTransactionByAccountList{" +
                "insertAccountList=" + insertAccountList +
                '}';
    }
}