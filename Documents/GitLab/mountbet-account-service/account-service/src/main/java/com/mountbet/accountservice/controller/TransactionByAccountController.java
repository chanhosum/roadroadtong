package com.mountbet.accountservice.controller;

import com.mountbet.accountservice.dto.InsertTransactionByAccountList;
import com.mountbet.accountservice.service.TransactionByAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/transactionbyaccount")
@RestController
public class TransactionByAccountController {
    private static final Logger LOG = LoggerFactory.getLogger(TransactionByAccountController.class);

    @Autowired
    private TransactionByAccountService transactionByAccountService;

    @PostMapping(path = "/restful", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String RESTful(@RequestHeader HttpHeaders httpHeaders, @RequestBody InsertTransactionByAccountList insertTransactionByAccountList) {
        LOG.debug("/restful");
        transactionByAccountService.RESTful(insertTransactionByAccountList);
        return "ok";
    }

}
