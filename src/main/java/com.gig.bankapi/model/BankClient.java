package com.gig.bankapi.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bank_client")
public class BankClient {

    @Id
    @Column(name = "bank_id")
    private Long bankId;

    @Id
    @Column(name = "client_id")
    private Long clientId;

    @JoinColumn(name = "bank_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Bank bank;
}
