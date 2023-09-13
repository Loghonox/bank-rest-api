package com.gig.bankaccountrestapi.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "account_transaction")
public class AccountTransaction  implements Serializable {



    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="account_transaction_id")
    private Long accountTransactionId;

    @OneToMany
    @JoinColumn(name="transaction_id")
    private List<Transaction> lstTransactionId;


    @JoinColumn(name = "account_id")
    @ManyToOne(optional = false)
    private Account accountId;



    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account account) {
        this.accountId = accountId;
    }

    public Long getTransactionId() {
        return accountTransactionId;
    }



    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountTransactionId,lstTransactionId);
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
        AccountTransaction other = (AccountTransaction) obj;
        return Objects.equals(accountId, other.accountId)
                && Objects.equals(accountTransactionId, other.accountTransactionId)
                && Objects.equals(lstTransactionId, other.lstTransactionId)

                ;
    }

}
