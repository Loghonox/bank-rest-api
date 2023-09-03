package com.gig.bankapi.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "ammount")
    private Long ammount;

    @Column(name = "asofdate")
    private LocalDateTime asofdate;

    @JoinColumn(name = "transaction_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private AccountTransaction accountTransaction;


    public void makeTransaction(Long ammount,LocalDateTime asofdate,AccountTransaction accountTransaction){
        this.ammount= ammount;
        this.asofdate=asofdate;
        this.accountTransaction=accountTransaction;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getAmmount() {
        return ammount;
    }

    public LocalDateTime getAsofdate() {
        return asofdate;
    }

    public AccountTransaction getAccountTransaction() {
        return accountTransaction;
    }
}
