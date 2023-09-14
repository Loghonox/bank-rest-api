package com.gig.bankaccountrestapi.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private Long clientId;

    @Column(nullable = false, name = "first_name")
    private String firstName;


    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "birth_date")
    private String birthDate;


    @JoinColumn(name = "client_account_id")
    @OneToMany
    private List<ClientAccount> lstClientAccount;



    @JoinColumn(name = "loan_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Loan> lstLoan;

    public Client(Long clientId, String firstName, String lastName, String birthDate) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }



    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, firstName, lastName, birthDate);
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
        Client other = (Client) obj;
        return Objects.equals(clientId, other.clientId)
                && Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName)
                && Objects.equals(birthDate, other.birthDate);
    }

}