package com.mountbet.accountservice.repository;

import com.mountbet.accountservice.entity.ActivityByAccount;
import com.mountbet.accountservice.entity.key.ActivityByAccountKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ActivityByAccountRepository extends CassandraRepository<ActivityByAccount, ActivityByAccountKey> {
}
