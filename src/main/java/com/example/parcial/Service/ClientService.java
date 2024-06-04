package com.example.parcial.Service;

import com.example.parcial.JPA.ClientJPA;
import com.example.parcial.Model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientJPA clientJPA;

    public List<Client> getAllClients() {
        return clientJPA.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientJPA.findById(id);
    }

    public void saveClient(Client client) {
        clientJPA.save(client);
    }

    public void deleteClientById(Long id) {
        clientJPA.deleteById(id);
    }
}
