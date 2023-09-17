package com.gig.bankaccountrestapi.service;


import com.gig.bankaccountrestapi.model.Account;
import com.gig.bankaccountrestapi.model.Transaction;
import com.gig.bankaccountrestapi.repository.AccountRepository;
import com.gig.bankaccountrestapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements AccountServiceInterface {
    @Autowired
    AccountRepository accountRepository;


    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Account> getAll() {
        List<Account> lstAccounts;

        lstAccounts = accountRepository.findAll();
        return lstAccounts;
    }

    @Override
    public Account findAccountById(Long id) throws Exception {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent())
            return account.get();
        else
            throw new Exception("no account found");

    }

    @Override
    public Account createAccount(Account account) throws Exception {
        Account newAccount;
        try {
            newAccount = accountRepository.save(account);
        } catch (Exception e) {
            throw new Exception("couldn't create account from:" + account.getIban() + e.getMessage());
        }
        return newAccount;
    }

    @Override
    public Account updateAccount(Account accountToUpdate, Long id) throws Exception {
        Optional<Account> foundAccount = accountRepository.findById(id);
        if (foundAccount.isPresent()) {
            Account accountUpdated = foundAccount.get();

            accountUpdated.updateAccount(accountToUpdate.getAccountName(), accountToUpdate.getIban(),
                    accountToUpdate.getBalance(), accountToUpdate.getCurrency());
            return accountRepository.save(accountUpdated);
        } else
            throw new Exception("couldn't update account from:" + accountToUpdate.getIban());
    }

    @Override
    public void deleteAccount(Long id) throws Exception {
        try {
            accountRepository.delete(accountRepository.findById(id).get());
        } catch (Exception e) {
            throw new Exception("error occurred while deleting Account" + accountRepository.findById(id).get().getIban());

        }
    }

    @Override
    public void withdrawMoneyTransaction(Long accountId, Transaction transaction) throws Exception {

        Account account = accountRepository.findById(accountId).get();
        try {
            transactionRepository.save(transaction);
            Long newBalance = account.getBalance()-transaction.getAmmount();

            if (newBalance < 0) {
                throw new Exception("Insufficient money from:" + account.getIban());
            }
            System.out.println("accountId"+accountId+"-->"+transaction.getAmmount());
            System.out.println(newBalance);
            account.updateAccount(account.getAccountName(), account.getIban(), newBalance, account.getCurrency());
            accountRepository.save(account);
        } catch (Exception e) {
            throw new Exception("couldn't submit transaction from:" + account.getIban());
        }
    }
}
