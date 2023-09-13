package com.gig.bankaccountrestapi.service;

import com.gig.bankaccountrestapi.model.Transaction;

import java.util.List;

public interface TransactionInterface {

    public List<Transaction> getAll();

    public Transaction getTransactionById(Long id) throws Exception;

    public Transaction addTransaction(Transaction transaction) throws Exception;


}
