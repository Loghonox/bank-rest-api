package com.gig.bankaccountrestapi.service;


import com.gig.bankaccountrestapi.model.Account;
import com.gig.bankaccountrestapi.model.Transaction;

import java.util.List;

public interface AccountServiceInterface {

    public List<Account> getAll();

    public Account findAccountById(Long id) throws Exception;

    public Account createAccount(Account account) throws Exception;

    public Account updateAccount(Account accountToUpdate, Long id) throws Exception;

    public void deleteAccount(Long id) throws Exception;

    public void withdrawMoneyTransaction(Long accountId, Transaction transaction) throws Exception;

}
