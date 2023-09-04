package com.gig.bankapi.controller;


import com.gig.bankapi.model.Account;
import com.gig.bankapi.service.account.AccountService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    AccountService accountService;
    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    @ApiOperation("Find all Accounts")
    @ApiResponses(value = @ApiResponse(code = 200, message = "List of accounts received successfully"))
    List<Account> findAll() {
        return accountService.getAll();
    }

    @PostMapping
    @ApiOperation("Add new Account")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Account created successfully"),
            @ApiResponse(code = 409, message = "An account already exists with same IBAN")})
    ResponseEntity<Object> newAccount(@RequestBody @Valid Account newAccount) throws Exception {
        Long accountId = accountService.createAccount(newAccount).getAccountId();
        if (accountId == (null)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
            JSONObject accObj = new JSONObject();
            accObj.put("id", accountId);
            return new ResponseEntity<>(accObj.toJSONString(), HttpStatus.CREATED);
        }
    }

    @GetMapping("{accountId}")
    @ApiOperation("Find Account by Id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Account found"),
            @ApiResponse(code = 404, message = "Could not find account")})
    Account getAccountById(@PathVariable Long accountId) throws Exception {
        return accountService.findAccountById(accountId);
    }

    @PutMapping("{accountId}")
    @ApiOperation("Update Account")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Account updated successfully"),
            @ApiResponse(code = 404, message = "Could not find account to update"),
            @ApiResponse(code = 400, message = "Field validation failed")})
    Account updateAccount(@RequestBody @Valid Account newAccount, @PathVariable Long accountId) throws Exception {
        return accountService.updateAccount(newAccount, accountId);
    }

    @DeleteMapping("{accountId}")
    @ApiOperation("Delete Account by Id")
    @ApiResponses(value = {@ApiResponse(code = 204, message = "Account deleted successfully"),
            @ApiResponse(code = 404, message = "Could not find account to delete")})
    ResponseEntity<Object> removeAccount(@PathVariable Long accountId) throws Exception {
        if (getAccountById(accountId) != null) {
            accountService.deleteAccount(accountId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else
            throw new Exception("account not found");
    }
}
