package com.gig.bankaccountrestapi.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "loan")
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="loan_id")
    private Long loanId;

    @JoinColumn(name = "client_id")
    @ManyToOne(optional = false)
    private Client clientId;


    @Column(name ="loan_ammount")
    private Long loanAmmount;


    @Column(name ="start_date")
    private LocalDateTime startDate;

    @Override
    public int hashCode() {
        return Objects.hash(loanId, clientId,loanAmmount,startDate);
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
        Loan other = (Loan) obj;
        return Objects.equals(clientId, other.clientId)
                && Objects.equals(loanAmmount, other.loanAmmount)
                && Objects.equals(startDate, other.startDate);
    }

}
