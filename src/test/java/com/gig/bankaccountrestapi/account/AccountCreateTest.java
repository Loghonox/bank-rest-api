package com.gig.bankaccountrestapi.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gig.bankaccountrestapi.model.Account;
import com.gig.bankaccountrestapi.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AccountCreateTest {


    private MockMvc mockMvc ;

    @Autowired
    AccountRepository accountRepository;



    @BeforeEach
    void setUp() throws Exception {
        accountRepository.deleteAll();
    }
    @Test
    @Order(1)
    @DisplayName("1 - Must register an account successfully")
    void createAccountSuccessfully() throws Exception {
        final Account account = new Account( "Jose","MT84MALT011000012345MTLCAST001S",1L,"EUR");
        accountRepository.save(account);
        mockMvc.perform(post("/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(account)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

}