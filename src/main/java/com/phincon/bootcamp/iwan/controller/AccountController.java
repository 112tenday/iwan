package com.phincon.bootcamp.iwan.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.phincon.bootcamp.iwan.model.Account;
import com.phincon.bootcamp.iwan.service.AccountService;

import java.util.List;

@RestController
public class AccountController {
    static Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    static AccountService accountService;
    @Operation(summary = "Get a tutorial object by title", description = "API to return tutorial List")
    //mocking description
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
    })

//    @GetMapping ("/bootcamp/account/{id}")
//    public static Account getAccount(@PathVariable String id){
//        logger.info("getAccount id {}",id);
//        return accountService.getAccountById(id);
//    }

    @GetMapping ("/bootcamp/account/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable String id) throws Exception{
        logger.debug("getAccount id {}",id);
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping ("/bootcamp/account/")
    public ResponseEntity<List<Account>> getAccount() throws Exception{
        logger.debug("getAccounts ");
        return ResponseEntity.ok(accountService.getAll());
    }

    @GetMapping ("/bootcamp/account/{id}/{name}")
    public ResponseEntity<Account> getAccountByIdAndName(@PathVariable String id, @PathVariable String name) throws Exception{
        logger.debug("getAccount id={} name = {} ",id, name);
        return ResponseEntity.ok(accountService.getAccountByIdAndName(id, name));
    }



}
