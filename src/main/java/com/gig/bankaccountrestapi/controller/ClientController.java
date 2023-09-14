package com.gig.bankaccountrestapi.controller;


import com.gig.bankaccountrestapi.model.Client;
import com.gig.bankaccountrestapi.service.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@Tag(name = "client")
public class ClientController implements ClientControllerInterface {
    @Autowired
    ClientService clientService;


    @Override
    public ResponseEntity<Client> createClient(Client newClient) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.addClient(newClient));

    }

    @Override
    public ResponseEntity<List<Client>> getAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAll());

    }

    @Override
    public ResponseEntity<Client> getClientById(Long clientId) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.getClientById(clientId));

    }

    @Override
    public ResponseEntity<Object> updateClient(Long clientId, Client newClient) throws Exception {
        clientService.updateClient(newClient, clientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @Override
    public ResponseEntity<Object> removeClient(Long clientId) throws Exception {
        clientService.removeClient(clientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }





}
