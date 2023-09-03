package com.gig.bankapi.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client_account")
public class ClientAccount {

    @Id
    @Column(name="client_id")
    private Long clientId;

    @Id
    @Column(name="account_id")
    private Long account_id;


    @JoinColumn(name = "account_id", nullable = false)
    @OneToMany(fetch = FetchType.LAZY)
    private List<Account> lstAccount;




}
