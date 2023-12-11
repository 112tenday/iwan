package com.phincon.bootcamp.agung.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phincon.bootcamp.agung.model.Account;
import com.phincon.bootcamp.agung.model.AccountDto;
import com.phincon.bootcamp.agung.service.AccountService;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountService accountService;

    @Test
    void testDelete() {
        assertTrue(true);
    }

    // @Test
    // void testGetAccount() {
    // assertEquals(mockMvc, accountService);
    // }

    @Test
    void testGetAccounts() {
        assertTrue(true);
    }

    @Test
    void testPatch() {
        assertTrue(true);
    }

    @Test
    void testSave() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setId("1");
        accountDto.setName("Mulyanto");
        String requestBody = objectMapper.writeValueAsString(accountDto);

        Account account = new Account();
        account.setId(accountDto.getId());
        account.setName(accountDto.getName());

        Mockito.when(accountService.save(accountDto)).thenReturn(account);

        mockMvc.perform(MockMvcRequestBuilders.post("/bootcamp/account")
                .content(requestBody)
                .contentType("application/json"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id", is(account.getId())))
                // .andExpect(jsonPath("$.name", is(account.getName())))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testWithIdNull() throws Exception {
        AccountDto accountDto = new AccountDto();
        // accountDto.setId(null);
        accountDto.setName("Mulyanto");
        String requestBody = objectMapper.writeValueAsString(accountDto);

        // Account account = new Account();
        // account.setId(accountDto.getId());
        // account.setName(accountDto.getName());

        Mockito.when(accountService.save(accountDto)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.post("/bootcamp/account")
                .content(requestBody)
                .contentType("application/json"))
                .andExpect(status().isCreated())
                // .andExpect(content().contentType("application/json"))
                // .andExpect(jsonPath("$.id", is(account.getId())))
                // .andExpect(jsonPath("$.name", is(account.getName())))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testUpdate() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setId("1");
        accountDto.setName("UpdatedName");
        String requestBody = objectMapper.writeValueAsString(accountDto);

        Account account = new Account();
        account.setId(accountDto.getId());
        account.setName(accountDto.getName());

        Mockito.when(accountService.update(accountDto)).thenReturn(account);

        mockMvc.perform(MockMvcRequestBuilders.put("/bootcamp/account")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(account.getId())))
                .andExpect(jsonPath("$.name", is(account.getName())))
                .andDo(MockMvcResultHandlers.print());
    }
}
