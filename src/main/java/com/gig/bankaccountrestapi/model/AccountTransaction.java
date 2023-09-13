/*package com.gig.bankapi.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "account_transaction")
public class AccountTransaction  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="account_id")
    private Long accountId;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="transaction_id")
    private Long transactionId;






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

    @Override
    public int hashCode() {
        return Objects.hash(accountId, transactionId);
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
                && Objects.equals(transactionId, other.transactionId);
    }

}
 */