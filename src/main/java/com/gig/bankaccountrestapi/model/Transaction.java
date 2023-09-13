/*package com.gig.bankapi.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "ammount")
    private Long ammount;

    @Column(name = "asofdate")
    private LocalDateTime asofdate;



    public void makeTransaction(Long ammount,LocalDateTime asofdate){
        this.ammount= ammount;
        this.asofdate=asofdate;
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

}
*/