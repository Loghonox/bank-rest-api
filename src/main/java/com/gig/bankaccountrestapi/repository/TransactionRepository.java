package com.gig.bankaccountrestapi.repository;

import com.gig.bankaccountrestapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
