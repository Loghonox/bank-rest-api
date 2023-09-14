package com.gig.bankaccountrestapi.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "account")
@EnableAutoConfiguration
public class Account implements Serializable {
    @Id
    @Column(name = "account_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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



    public Account(String accountName, String iban, Long balance, String currency) {
        this.accountName = accountName;
        this.iban = iban;
        this.balance = balance;
        this.currency = currency;
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

    @Override
    public int hashCode() {
        return Objects.hash(accountName, iban, balance, currency);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Account other = (Account) obj;
        return Objects.equals(accountName, other.accountName)
                && Objects.equals(iban, other.iban)
                && Objects.equals(balance, other.balance)
                && Objects.equals(currency, other.currency);
    }

}
