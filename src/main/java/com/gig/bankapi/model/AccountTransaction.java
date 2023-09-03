package com.gig.bankapi.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "account_transaction")
public class AccountTransaction {

    @Id
    @Column(name="account_id")
    private Long accountId;

    @Id
    @Column(name="transaction_id")
    private Long transactionId;

    @JoinColumn(name = "transaction_id", nullable = false)
    @OneToMany(fetch = FetchType.LAZY)
    private List<Transaction> transaction;


    @JoinColumn(name = "account_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;



    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }
}
