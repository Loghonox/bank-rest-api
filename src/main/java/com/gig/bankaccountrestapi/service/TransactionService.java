package com.gig.bankaccountrestapi.service;

import com.gig.bankaccountrestapi.model.Transaction;
import com.gig.bankaccountrestapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements  TransactionInterface{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAll() {
        List<Transaction> lstTransactions;

        lstTransactions = transactionRepository.findAll();
        return lstTransactions;
    }

    @Override
    public Transaction getTransactionById(Long id) throws Exception {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent())
            return transaction.get();
        else
            throw new Exception("no account found");

    }

    @Override
    public Transaction addTransaction(Transaction transaction) throws Exception {
        Transaction newTransaction;
        try {
            newTransaction = transactionRepository.save(transaction);
        } catch (Exception e) {
            throw new Exception("couldn't create account from:" + transaction.getTransactionId());
        }
        return newTransaction;
    }




}
