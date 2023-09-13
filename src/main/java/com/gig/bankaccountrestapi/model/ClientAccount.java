package com.gig.bankaccountrestapi.model;

import jakarta.persistence.*;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "client_account")
public class ClientAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_account_id")
    private Long clientAccountId;

    @JoinColumn(name = "account_id")
    @OneToMany
    private List<Account> lstAccount;

    @JoinColumn(name = "client_id")
    @ManyToOne(optional = false)
    private Client clientId;



    @Override
    public int hashCode() {
        return Objects.hash(clientAccountId, lstAccount,clientId);
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
        ClientAccount other = (ClientAccount) obj;
        return Objects.equals(clientAccountId, other.clientAccountId)
                && Objects.equals(lstAccount, other.lstAccount)
                && Objects.equals(clientId, other.clientId)
                ;
    }

}
