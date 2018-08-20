package com.mountbet.accountservice.controller;

import com.mountbet.accountservice.dto.ClearedOrderSummaryReport;
import com.mountbet.accountservice.dto.CurrentOrderSummaryReport;
import com.mountbet.accountservice.dto.ListClearedOrders;
import com.mountbet.accountservice.dto.ListCurrentOrders;
import com.mountbet.accountservice.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author AnsonChan
 * @since 10/7/2018
 */
@RequestMapping(path = "/account")
@RestController
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @PostMapping(path = "/listCurrentOrders", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public CurrentOrderSummaryReport listCurrentOrders(@RequestHeader HttpHeaders httpHeaders, @RequestBody ListCurrentOrders listCurrentOrders) {
        LOG.debug("/listCurrentOrders");
        LOG.debug(listCurrentOrders.toString());
        CurrentOrderSummaryReport returns = accountService.listCurrentOrders(listCurrentOrders);
        return returns;
    }

    @PostMapping(path = "/listClearedOrders", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ClearedOrderSummaryReport listClearedOrders(@RequestHeader HttpHeaders httpHeaders, @RequestBody ListClearedOrders listClearedOrders) {
        LOG.debug("/listClearedOrders");
        LOG.debug(listClearedOrders.toString());
        ClearedOrderSummaryReport returns = accountService.listClearedOrders(listClearedOrders);
        return returns;
    }
}
