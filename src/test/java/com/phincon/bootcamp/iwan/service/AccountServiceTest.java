package com.phincon.bootcamp.iwan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.phincon.bootcamp.iwan.model.Account;
import com.phincon.bootcamp.iwan.repository.AccountRepository;

class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAccounts() {
        // Mock data
        List<Account> mockAccounts = new ArrayList<>();
        mockAccounts.add(new Account());
        mockAccounts.add(new Account());

        // Mock behavior
        when(accountRepository.findAll()).thenReturn(mockAccounts);

        // Test
        List<Account> result = accountService.getAllAccounts();

        // Assertion
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testGetAccountById() {
        // Mock data
        String accountId = "1L";
        Account mockAccount = new Account();
        mockAccount.setId(accountId);

        // Mock behavior
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(mockAccount));

        // Test
        Account result = accountService.getAccount(accountId);

        // Assertion
        assertNotNull(result);
        assertEquals(accountId, result.getId());
    }

    @Test
    void testCreateAccount() {
        // Mock data
        Account mockAccount = new Account();

        // Mock behavior
        when(accountRepository.save(mockAccount)).thenReturn(mockAccount);

        // Test
        Account result = accountService.createAccount(mockAccount);

        // Assertion
        assertNotNull(result);
    }

    @Test
    void testUpdateAccount() {
        // Mock data
        Account mockAccount = new Account();

        // Mock behavior
        when(accountRepository.save(mockAccount)).thenReturn(mockAccount);

        // Test
        Account result = accountService.updateAccount(mockAccount);

        // Assertion
        assertNotNull(result);
    }

    @Test
    void testDeleteAccount() {
        // Mock data
        Long accountId = 1L;

        // Test
        accountService.deleteAccount(accountId);
    }
}
