package com.phincon.bootcamp.iwan.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.phincon.bootcamp.iwan.model.Account;
import com.phincon.bootcamp.iwan.service.AccountService;

@RestController
public class AccountController {
    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;
    @Operation(summary = "Get a tutorial object by title", description = "API to return tutorial List")
    //mocking description
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
    })

    @GetMapping ("/bootcamp/account/{id}")
    public Account getAccount(@PathVariable String id){
        logger.info("getAccount id {}",id);
        return accountService.getAccountById(id);
    }


    }
