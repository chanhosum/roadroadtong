package com.mountbet.accountservice.service;

import com.mountbet.accountservice.dto.InsertTransactionByAccount;
import com.mountbet.accountservice.dto.InsertTransactionByAccountList;
import com.mountbet.accountservice.entity.TransactionByAccount;
import com.mountbet.accountservice.entity.key.TransactionByAccountKey;
import com.mountbet.accountservice.repository.TransactionByAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionByAccountService {
    private static final Logger LOG = LoggerFactory.getLogger(ActivityByAccountService.class);

    @Autowired
    private TransactionByAccountRepository transactionByAccountRepository;

    public void RESTful(InsertTransactionByAccountList insertTransactionByAccountList) {
        for (InsertTransactionByAccount insertTransactionByAccount : insertTransactionByAccountList.getInsertAccountList()) {
            TransactionByAccount transactionByAccount = new TransactionByAccount();

            TransactionByAccountKey transactionByAccountKey = new TransactionByAccountKey();
            transactionByAccountKey.setAccountId(insertTransactionByAccount.getAccountId());
            transactionByAccountKey.setDate(insertTransactionByAccount.getDate());
            transactionByAccount.setKey(transactionByAccountKey);

            transactionByAccount.setAbsoluteExRate(insertTransactionByAccount.getAbsoluteExRate());
            transactionByAccount.setBalance(insertTransactionByAccount.getBalance());
            transactionByAccount.setCommission(insertTransactionByAccount.getCommission());
            transactionByAccount.setCredit(insertTransactionByAccount.getCredit());
            transactionByAccount.setCurrency(insertTransactionByAccount.getCurrency());
            transactionByAccount.setDebit(insertTransactionByAccount.getDebit());
            transactionByAccount.setDescription(insertTransactionByAccount.getDescription());
            transactionByAccount.setOrigin(insertTransactionByAccount.getOrigin());
            transactionByAccount.setOriginId(insertTransactionByAccount.getOriginId());
            transactionByAccount.setOriginIdOld(insertTransactionByAccount.getOriginIdOld());

            transactionByAccountRepository.insert(transactionByAccount);
        }
    }

}
