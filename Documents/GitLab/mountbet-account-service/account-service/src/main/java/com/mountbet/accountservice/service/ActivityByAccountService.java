package com.mountbet.accountservice.service;

import com.mountbet.accountservice.repository.AccountRepository;
import com.mountbet.accountservice.repository.ActivityByAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author AnsonChan
 * @since 11/7/2018
 */
@Service
@Transactional
public class ActivityByAccountService {
    private static final Logger LOG = LoggerFactory.getLogger(ActivityByAccountService.class);

    @Autowired
    private ActivityByAccountRepository activityByAccountRepository;

}
