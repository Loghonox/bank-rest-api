package com.gig.bankapi.service.account;

import com.gig.bankapi.model.Account;

import java.util.List;

public interface AccountServiceInterface {

    public List<Account> getAll();

    public Account findAccountById(Long id) throws Exception;

    public Account createAccount(Account account) throws Exception;

    public Account updateAccount(Account accountToUpdate, Long id) throws Exception;

    public void deleteAccount(Long id) throws Exception;
}
