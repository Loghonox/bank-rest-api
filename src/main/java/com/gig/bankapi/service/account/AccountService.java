package com.gig.bankapi.service.account;

import com.gig.bankapi.model.Account;
import com.gig.bankapi.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements AccountServiceInterface {
    private AccountRepo accountRepository;

    @Autowired
    public void setAccountRepository(AccountRepo accountRepository) {
        this.accountRepository = accountRepository;
    }


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
        Account newAccount = new Account();
        try {
            newAccount = accountRepository.save(account);
        } catch (Exception e) {
            throw new Exception("couldn't create account from:" + account.getIban());
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
}
