package com.gig.bankaccountrestapi.controller;



import com.gig.bankaccountrestapi.model.Account;
import com.gig.bankaccountrestapi.service.AccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Tag(name = "account")
public class AccountController implements AccountControllerInterface {
    @Autowired
    AccountService accountService;


    public ResponseEntity<Account> createAccount(Account newAccount) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(newAccount));


    }


    //@ApiOperation("Find Account by Id")
    public ResponseEntity<Account> getAccountById(Long accountId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.findAccountById(accountId));
    }

    @Override
    public ResponseEntity<Object> updateAccount(Long accountId, Account newAccount) throws Exception {
        accountService.updateAccount(newAccount, accountId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }





    public ResponseEntity<Object> removeAccount(Long accountId) throws Exception {
        accountService.deleteAccount(accountId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}