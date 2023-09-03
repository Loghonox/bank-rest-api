package com.gig.bankapi.model;

import jakarta.validation.constraints.Size;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @Column(name = "bank_id")
    private Long bankId;
    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "swift_code")
    @Size(min = 8, max = 11)
    private Long swiftCode;

    @JoinColumn(name = "bank_id", nullable = false)
    @OneToMany(fetch = FetchType.LAZY)
    private List<BankClient> lstBankClient;




    public void createBankAccount(){

    }

}
