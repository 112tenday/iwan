package com.phincon.bootcamp.agung.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// import com.phincon.bootcamp.agung.controller.AccountController;
import com.phincon.bootcamp.agung.model.Account;
import com.phincon.bootcamp.agung.service.AccountService;

@SpringBootTest
class AccountControllerTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @Test
    void getAllAccountsTest() {
        // Arrange
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account());
        when(accountService.getAllAccounts()).thenReturn(accounts);

        // Act
        ResponseEntity<List<Account>> response = accountController.getAllAccounts();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(accounts, response.getBody());
    }

    @Test
    void getAccountByIdTest() {
        // Arrange
        Long accountId = 1L;
        Account account = new Account();
        when(accountService.getAccountById(accountId)).thenReturn(account);

        // Act
        ResponseEntity<Account> response = accountController.getAccountById(accountId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(account, response.getBody());
    }

    @Test
    void createAccountTest() {
        // Arrange
        Account account = new Account();
        when(accountService.createAccount(account)).thenReturn(account);

        // Act
        ResponseEntity<Account> response = accountController.createAccount(account);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(account, response.getBody());
    }

    @Test
    void updateAccountTest() {
        // Arrange
        Long accountId = 1L;
        Account account = new Account();
        when(accountService.getAccountById(accountId)).thenReturn(account);

        // Act
        ResponseEntity<Account> response = accountController.updateAccount(accountId, account);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(account, response.getBody());
    }

    @Test
    void updateAccountNotFoundTest() {
        // Arrange
        Long accountId = 1L;
        when(accountService.getAccountById(accountId)).thenReturn(null);

        // Act
        ResponseEntity<Account> response = accountController.updateAccount(accountId, new Account());

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void deleteAccountTest() {
        // Arrange
        Long accountId = 1L;

        // Act
        ResponseEntity<Void> response = accountController.deleteAccount(accountId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(accountService, times(1)).deleteAccount(accountId);
    }

    // Add more tests for other controller methods as needed
}
