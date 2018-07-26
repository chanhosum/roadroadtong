package com.mountbet.accountservice.controller;

import com.mountbet.accountservice.dto.InsertAccountList;
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

    @PostMapping(path = "/restful", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String RESTful(@RequestHeader HttpHeaders httpHeaders, @RequestBody InsertAccountList insertAccountList) {
        LOG.debug("/restful");
        accountService.RESTful(insertAccountList);
        return "ok";
    }
}
