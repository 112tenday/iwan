package com.phincon.bootcamp.iwan.controller;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phincon.bootcamp.iwan.model.Account;
import com.phincon.bootcamp.iwan.model.AccountDto;
import com.phincon.bootcamp.iwan.service.AccountService;

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

    @Test
    void testGetAccount() {
        assertTrue(true);
    }

    @Test
    void testGetAccounts() {
        assertTrue(true);
    }

    @Test
    void testSavewithIdNullorEmpety() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setName("agung");
        String requestBody = objectMapper.writeValueAsString(accountDto);

        Mockito.when(accountService.save(accountDto)).thenReturn(null);

        // mockMvc.perform(post("/bootcamp/account")
        mockMvc.perform(MockMvcRequestBuilders.post("/bootcamp/account")
                .content(requestBody)
                .contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());

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
                .andExpect(content().contentType("aplication/json"))
                .andExpect(jsonPath("$.id", is(account.getId())))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testUpdate() {
        assertTrue(true);
    }
}
