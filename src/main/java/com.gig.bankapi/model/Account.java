package com.gig.bankapi.model;

import jakarta.validation.constraints.Size;

import javax.persistence.*;


@Entity
@Table(name = "account")

public class Account {
    @Id
    private Long account_id;

    @Column(nullable = false)
    private String account_name;

    @Column(nullable = false)
    @Size(max = 31) //TODO test if there's a min
    private String iban;

    @Column(nullable = false)
    private Long balance;

    @Column(nullable = false)
    private String currency;

    @JoinColumn(name = "account_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Client client;


    public void setAccount_id(Long id) {
        this.account_id = id;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
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
