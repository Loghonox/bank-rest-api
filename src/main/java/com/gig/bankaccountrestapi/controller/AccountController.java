package com.gig.bankaccountrestapi.controller;


import com.gig.bankaccountrestapi.model.Account;
import com.gig.bankaccountrestapi.model.Transaction;
import com.gig.bankaccountrestapi.service.AccountService;
import com.gig.bankaccountrestapi.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
@Tag(name = "account")
public class AccountController implements AccountControllerInterface {
    @Autowired
    AccountService accountService;

    public ResponseEntity<Account> createAccount(Account newAccount) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(newAccount));


    }

    @Override
    public ResponseEntity<List<Account>> getAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getAll());

    }


    //@ApiOperation("Find Account by Id")
    public ResponseEntity<Account> getAccountById(Long accountId) throws Exception {
        System.out.println("---------->"+accountId);
        return ResponseEntity.status(HttpStatus.OK).body(accountService.findAccountById(accountId));
    }

    @Override
    public ResponseEntity<Object> updateAccount(Long accountId, Account newAccount) throws Exception {
        accountService.updateAccount(newAccount, accountId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @Override
    public ResponseEntity<Object> withdrawMoneyTransaction(Long accountId,Transaction transaction) throws Exception {
        accountService.withdrawMoneyTransaction(accountId, transaction);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    public ResponseEntity<Object> removeAccount(Long accountId) throws Exception {
        accountService.deleteAccount(accountId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
