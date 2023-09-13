package com.gig.bankaccountrestapi.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bank_client")
public class BankClient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bank_client_id", nullable = false)
    private Long bank_client_id;


    @JoinColumn(name = "bank_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Bank bank;

    @JoinColumn(name = "client_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @Override
    public int hashCode() {
        return Objects.hash(bank_client_id, client, bank);
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
        BankClient other = (BankClient) obj;
        return Objects.equals(bank_client_id, other.bank_client_id)
                && Objects.equals(client, other.client)
                && Objects.equals(bank, other.bank);
    }
}
