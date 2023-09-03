package com.gig.bankapi.model;

import jakarta.validation.constraints.Size;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "account")

public class Account {
    @Id
    @Column(name = "account_id")
    private Long accountId;

    @Column(nullable = false,name="account_name")
    private String accountName;

    @Column(nullable = false)
    @Size(max = 31) //TODO test if there's a min
    private String iban;

    @Column(nullable = false)
    private Long balance;

    @Column(nullable = false)
    private String currency;


    @JoinColumn(name = "account_id", nullable = false)
    @OneToMany(fetch = FetchType.LAZY)
    private List<AccountTransaction> lstAccountTransaction;



    public void setAccountId(Long id) {
        this.accountId = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String account_name) {
        this.accountName = account_name;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
