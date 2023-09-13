package com.gig.bankaccountrestapi.repository;

import com.gig.bankaccountrestapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
