package com.mountbet.accountservice.dto;

import java.util.ArrayList;
import java.util.List;

public class InsertAccountList {
    private List<InsertAccount> insertAccountList = new ArrayList<>();

    public List<InsertAccount> getInsertAccountList() {
        return insertAccountList;
    }

    public void setInsertAccountList(List<InsertAccount> insertAccountList) {
        this.insertAccountList = insertAccountList;
    }

    @Override
    public String toString() {
        return "InsertAccountList{" +
                "insertAccountList=" + insertAccountList +
                '}';
    }
}
