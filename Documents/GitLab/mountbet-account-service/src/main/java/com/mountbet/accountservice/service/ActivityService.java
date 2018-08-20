package com.mountbet.accountservice.service;

import com.mountbet.accountservice.repository.ActivityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author AnsonChan
 * @since 11/7/2018
 * The service that for ActivityBy table on Cassandra.
 */
@Service
@Transactional
public class ActivityService {
    private static final Logger LOG = LoggerFactory.getLogger(ActivityService.class);

    @Autowired
    private ActivityRepository activityRepository;

}