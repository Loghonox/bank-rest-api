package com.gig.bankaccountrestapi.model;

import jakarta.persistence.*;

import java.io.Serializable;

import java.util.Objects;

@Entity
@Table(name = "client_account")
public class ClientAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_account_id")
    private Long clientAccountId;

    @JoinColumn(name = "account_id",insertable=false, updatable=false)
    @ManyToOne
    private Account account;

    @JoinColumn(name = "client_id")
    @ManyToOne(optional = false)
    private Client client;



    @Override
    public int hashCode() {
        return Objects.hash(clientAccountId, account, client);
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
                && Objects.equals(account, other.account)
                && Objects.equals(client, other.client)
                ;
    }

}
