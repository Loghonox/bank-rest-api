package com.gig.bankaccountrestapi.service;

import com.gig.bankaccountrestapi.model.Client;
import com.gig.bankaccountrestapi.model.Transaction;

import java.util.List;

public interface ClientIServiceInterface {

    public List<Client> getAll();

    public Client getClientById(Long clientId) throws Exception;

    public Client addClient(Client client) throws Exception;

    Client updateClient(Client clientToUpdate, Long id) throws Exception;

    public void removeClient(Long clientId) throws Exception;


}
