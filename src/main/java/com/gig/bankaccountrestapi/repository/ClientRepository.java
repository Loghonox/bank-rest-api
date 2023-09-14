package com.gig.bankaccountrestapi.repository;

import com.gig.bankaccountrestapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
