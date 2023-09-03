package com.gig.bankapi.repository;

import com.gig.bankapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
