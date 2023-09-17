package com.gig.bankaccountrestapi.model;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bank")
@EnableAutoConfiguration
public class Bank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bank_id", nullable = false)
    private Long bankId;
    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "swift_code")
    //@Size(min = 8, max = 11)
    private Long swiftCode;


    @Override
    public int hashCode() {
        return Objects.hash(bankId, bankName, swiftCode);
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
        Bank other = (Bank) obj;
        return Objects.equals(bankId, other.bankId)
                && Objects.equals(bankName, other.bankName)
                && Objects.equals(swiftCode, other.swiftCode);
    }

}
