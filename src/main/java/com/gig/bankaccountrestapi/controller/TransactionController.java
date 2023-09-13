package com.gig.bankaccountrestapi.controller;


import com.gig.bankaccountrestapi.model.Account;
import com.gig.bankaccountrestapi.model.Transaction;
import com.gig.bankaccountrestapi.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Tag(name = "transaction")
public class TransactionController implements  TransactionControllerInterface{

    @Autowired
    TransactionService transactionService;

    @Override
    public ResponseEntity<Account> newTransaction(Transaction newTransaction) throws Exception {
        return null;
    }
}
