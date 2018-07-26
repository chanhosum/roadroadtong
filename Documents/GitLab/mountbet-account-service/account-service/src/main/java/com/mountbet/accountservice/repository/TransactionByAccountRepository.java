package com.mountbet.accountservice.repository;

import com.mountbet.accountservice.entity.TransactionByAccount;
import com.mountbet.accountservice.entity.key.TransactionByAccountKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface TransactionByAccountRepository extends CassandraRepository<TransactionByAccount, TransactionByAccountKey> {
}
