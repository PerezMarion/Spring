package com.poe.crmSpringboot.business.service;

import com.poe.crmSpringboot.business.Client;
import com.poe.crmSpringboot.business.Order;
import com.poe.crmSpringboot.dao.ClientRepository;
import com.poe.crmSpringboot.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// Classe avec code métier d'où le package business, puis package service car c'est là que se trouve les
// méthodes que l'on va utiliser dans les controllers : "vrai" code métier
@Service
public class ServicesClientOrder {

// --------------------------------------------- Partie Client --------------------------------------------- //
// -------------------------- Avec utilisation de l'interface ClientRepository ----------------------------- //

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public boolean deleteClient(Long id) {
        if(clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateClient(Client client) {
        if(clientRepository.existsById(client.getId())) {
            clientRepository.save(client);
            return true;
        } else {
            return false;
        }
    }

// --------------------------------------------- Partie Client --------------------------------------------- //
// ------------------------- Avant utilisation de l'interface ClientRepository ----------------------------- //

    //ArrayList<Client> clients = new ArrayList<>();
    //long index = 0;

    //public List<Client> getAllClients() {
        //return clients;
    //}

    //public Optional<Client> findClientById(Long id) {
        //for(Client client : clients) {
            //if(client.getId().equals(id)) {
                //return Optional.of(client);
            //}
        //}
        //return Optional.empty();
    //}

    //public void addClient(Client client) {
        //index++;
        //client.setId(index);
        //clients.add(client);
    //}

    //public boolean deleteClient(Long id) {
        //for(Client client : clients) {
            //if(client.getId().equals(id)) {
                //clients.remove(client);
                //return true;
            //}
        //}
        //return false;
    //}

    //public boolean updateClient(Client newDataClient) {
        //for(Client oldDataClient : clients) {
            //if(oldDataClient.getId().equals(newDataClient.getId())) {
                //clients.remove(oldDataClient);
                //clients.add(newDataClient);
                //return true;
            //}
        //}
        //return false;
    //}

// --------------------------------------------- Partie Order --------------------------------------------- //

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> findOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public boolean deleteOrder(Long id) {
        if(orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateOrder(Order order) {
        if(orderRepository.existsById(order.getId())) {
            orderRepository.save(order);
            return true;
        } else {
            return false;
        }
    }
}