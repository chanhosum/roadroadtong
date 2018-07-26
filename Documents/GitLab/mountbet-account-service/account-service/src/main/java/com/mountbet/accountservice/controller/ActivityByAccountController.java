package com.mountbet.accountservice.controller;

import com.mountbet.accountservice.service.ActivityByAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AnsonChan
 * @since 11/7/2018
 */
@RequestMapping(path = "/activitybyaccount")
@RestController
public class ActivityByAccountController {
    private static final Logger LOG = LoggerFactory.getLogger(ActivityByAccountController.class);

    @Autowired
    private ActivityByAccountService activityByAccountService;
}
