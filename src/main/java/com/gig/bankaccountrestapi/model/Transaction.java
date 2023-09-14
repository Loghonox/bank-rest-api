package com.gig.bankaccountrestapi.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "transaction")
@EnableAutoConfiguration
public class Transaction implements Serializable {

    @Id
    @Column(name = "transaction_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "ammount")
    private Long ammount;

    @Column(name = "asofdate")
    private LocalDateTime asofdate;


    public void makeTransaction(Long ammount, LocalDateTime asofdate) {
        this.ammount = ammount;
        this.asofdate = asofdate;
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

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, ammount, asofdate);
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
        Transaction other = (Transaction) obj;
        return Objects.equals(transactionId, other.transactionId)
                && Objects.equals(ammount, other.ammount)
                && Objects.equals(asofdate, other.asofdate);
    }

}
