package com.poe.crmSpringboot.business.service;

import com.poe.crmSpringboot.business.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

// Classe avec code métier d'où le package business, puis package service car c'est là que se trouve les
// méthodes que l'on va utiliser dans les controllers : "vrai" code métier
@org.springframework.stereotype.Service
public class Service {

    ArrayList<Client> clients = new ArrayList<>();

    @GetMapping("clients")
    public List<Client> getAllClients() {

        return clients;
    }

    public void addClient(Client client) {

        clients.add(client);
    }
}
