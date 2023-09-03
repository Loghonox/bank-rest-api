package com.gig.bankapi.model;


import javax.naming.Name;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name ="client_id")
    private Long clientId;

    @Column(nullable = false,name="first_name")
    private String firstName;


    @Column(nullable = false,name="last_name")
    private String lastName;

    @Column(nullable = false,name="birth_date")
    private String birthDate;

    @JoinColumn(name = "client_id", nullable = false)
    @OneToMany(fetch = FetchType.LAZY)
    private List<ClientAccount> lstClientAccount;

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }
}
