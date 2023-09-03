package com.gig.bankapi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @Column(name ="loan_id")
    private Long loanId;

    @Id
    @Column(name ="client_id")
    private Long clientId;


    @Column(name ="loan_ammount")
    private Long loanAmmount;


    @Column(name ="start_date")
    private LocalDateTime startDate;

}
