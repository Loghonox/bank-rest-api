package com.gig.bankaccountrestapi.controller;


import com.gig.bankaccountrestapi.model.Transaction;
import com.gig.bankaccountrestapi.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@Tag(name = "transaction")
public class TransactionController implements TransactionControllerInterface {

    @Autowired
    TransactionService transactionService;

    @Override
    public ResponseEntity<Transaction> addTransaction(Transaction newTransaction) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.addTransaction(newTransaction));
    }


    @Override
    public ResponseEntity<Transaction> getAccountById(Long transactionId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getTransactionById(transactionId));
    }

    @Override
    public ResponseEntity<List<Transaction>> getAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getAll());

    }

}
