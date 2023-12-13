package com.phincon.bootcamp.agung.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.phincon.bootcamp.agung.model.Account;
import com.phincon.bootcamp.agung.model.AccountDto;
import com.phincon.bootcamp.agung.service.AccountService;

import jakarta.validation.Valid;

@RestController
public class AccountController {
    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @GetMapping ("/bootcamp/account/{id}")
    public Account get Account(@PathVariable String id){
        logger.info (format:"getAccount id {}",id);

        return accountService.getAccountById(id);
    }


    }
