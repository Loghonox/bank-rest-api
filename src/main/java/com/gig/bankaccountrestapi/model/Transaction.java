package com.gig.bankaccountrestapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "transaction")
@EnableAutoConfiguration
public class Transaction implements Serializable {

    @Id
    @Column(name = "transaction_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "ammount", nullable = false)
    private Long ammount;

    @Column(name = "asofdate")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime asofdate;


    public Transaction(Long ammount, LocalDateTime asofdate) {
        this.ammount = ammount;
        this.asofdate = asofdate;
    }

    public Transaction() {

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
