package com.gig.bankaccountrestapi.service;


import com.gig.bankaccountrestapi.model.Client;
import com.gig.bankaccountrestapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements ClientIServiceInterface {
    @Autowired
    ClientRepository clientRepository;


    @Override
    public List<Client> getAll() {
        List<Client> lstClients;

        lstClients = clientRepository.findAll();
        return lstClients;
    }


    @Override
    public Client getClientById(Long id) throws Exception {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent())
            return client.get();
        else
            throw new Exception("no client found");

    }

    @Override
    public Client addClient(Client client) throws Exception {
        Client newClient;
        try {
            newClient = clientRepository.save(client);
        } catch (Exception e) {
            throw new Exception("couldn't create client from:" + client.getClientId() + e.getMessage());
        }
        return newClient;
    }

    @Override
    public Client updateClient(Client clientToUpdate, Long id) throws Exception {
        Optional<Client> foundClient = clientRepository.findById(id);
        if (foundClient.isPresent()) {
            Client clientUpdated = foundClient.get();
            clientUpdated.upcateClient(clientToUpdate.getFirstName(), clientToUpdate.getLastName(), clientToUpdate.getBirthDate());
            return clientRepository.save(clientUpdated);
        } else
            throw new Exception("couldn't update client from:" + clientToUpdate.getClientId());
    }

    @Override
    public void removeClient(Long id) throws Exception {
        try {
            clientRepository.delete(clientRepository.findById(id).get());
        } catch (Exception e) {
            throw new Exception("error occurred while deleting Account" + clientRepository.findById(id).get().getClientId());

        }
    }
}
