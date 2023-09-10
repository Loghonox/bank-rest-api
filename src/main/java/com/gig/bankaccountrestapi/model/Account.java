package com.gig.bankaccountrestapi.model;

//import jakarta.validation.constraints.Size;



import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;


@Entity
@Table(name = "account")
public class Account implements Serializable {
    @Id
    @Column(name = "account_id", updatable = false, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long accountId;

    @Column(nullable = false, name = "account_name")
    private String accountName;

    @Column(nullable = false)
    // @Size(max = 31) //TODO test if there's a min
    private String iban;

    @Column(nullable = false)
    private Long balance;

    @Column(nullable = false)
    private String currency;
/*
    @JoinColumn(name = "account_id", nullable = false)
    @OneToMany(fetch = FetchType.LAZY)
    private List<ClientAccount> lstAccount;

*/


    public Account( String accountName, String iban, Long balance, String currency) {
        this.accountName = accountName;
        this.iban = iban;
        this.balance = balance;
        this.currency = currency;
    }

    public Account() {

    }

    public void updateAccount(String accountName, String iban, Long balance, String currency) {
        this.accountName = accountName;
        this.iban = iban;
        this.balance = balance;
        this.currency = currency;
    }


    public Long getAccountId() {
        return accountId;
    }

    public String getIban() {
        return iban;
    }


    public String getAccountName() {
        return accountName;
    }


    public Long getBalance() {
        return balance;
    }


    public String getCurrency() {
        return currency;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
