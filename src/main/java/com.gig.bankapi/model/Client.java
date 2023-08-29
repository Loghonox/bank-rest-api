package com.gig.bankapi.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    private Long client_id;

    @Column(nullable = false,name="first_name")
    private String firstName;


    @Column(nullable = false,name="last_name")
    private String lastName;

    @Column(nullable = false,name="birth_date")
    private String birthDate;

    @JoinColumn(name = "account_id", nullable = false)
    @OneToMany(fetch = FetchType.LAZY)
    private List<Account> lstAccount;

    public void setClient_id(Long clientId) {
        this.client_id = clientId;
    }

    public Long getClient_id() {
        return client_id;
    }
}
