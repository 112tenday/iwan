package com.phincon.bootcamp.iwan.service;

import com.phincon.bootcamp.iwan.model.Account;
import com.phincon.bootcamp.iwan.repository.AccountRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class AccountServiceImplTest {

    @Mock
    AccountRepository repository;

    @InjectMocks
    AccountServiceImpl accountServiceImpl;

    Account account;

    @BeforeAll
    void setup() {
        account = new Account();
        accountServiceImpl = new AccountServiceImpl(repository);
    }
    @Test
    void testCeratedSucces() {
        when (repository.create(account)).thenReturn(account);
        Account accountCreated = accountServiceImpl.create(account);
        assertNotNull(accountCreated.getId());

    }
    @Test
    void getAccountByIdSucces() throws Exception{
        String id = "1";
        when(repository.getAccountById(id)).thenReturn(account);
        Account data= accountServiceImpl.getAccountById(id);
        assertNotNull(data);
    }

    @Test
    void getAccounts(){
        List<Account>accounts = new ArrayList<>();
        accounts.add(account);
        Account account2 = new Account();
        account2 = account;
        accounts.add(account2);

        when(repository.getAll()).thenReturn(accounts);
        List<Account>result =accountServiceImpl.getAll();
        assertEquals(2,result.size());

    }
    @Test
    void updateSuccess(){
        when(repository.update(account)).thenReturn(account);
        assertNotNull(accountServiceImpl.update(account));
    }
    @Test
    void deleteSuccess(){
        String id = "1";
        account.setStatus("inactive");
        when(repository.delete(id)).thenReturn(account);
        Account accountDelete = accountServiceImpl.delete(id);
        assertEquals("inactive", accountDelete.getStatus());

    }




}


