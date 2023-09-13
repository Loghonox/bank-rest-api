package com.gig.bankaccountrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.gig.bankaccountrestapi.model")
public class BankAccountRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountRestApiApplication.class, args);
    }

}
