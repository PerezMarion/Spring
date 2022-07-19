package com.poe.crmSpringboot.business.service;

import com.poe.crmSpringboot.business.Client;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Classe avec code métier d'où le package business, puis package service car c'est là que se trouve les
// méthodes que l'on va utiliser dans les controllers : "vrai" code métier
@org.springframework.stereotype.Service
public class Service {

    ArrayList<Client> clients = new ArrayList<>();
    long index = 0;

    public List<Client> getAllClients() {

        return clients;
    }

    public Optional<Client> findClientById(Long id) {
        for(Client client : clients) {
            if(client.getId().equals(id)) {
                return Optional.of(client);
            }
        }
        return Optional.empty();
    }

    public void addClient(Client client) {

        index++;
        client.setId(index);
        clients.add(client);
    }
}