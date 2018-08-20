package com.mountbet.accountservice.repository;

import com.mountbet.accountservice.entity.Account;
import com.mountbet.accountservice.entity.key.AccountKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface AccountRepository extends CassandraRepository<Account, AccountKey> {
}
