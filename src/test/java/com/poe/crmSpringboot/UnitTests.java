package com.poe.crmSpringboot;

import com.poe.crmSpringboot.business.Client;
import com.poe.crmSpringboot.business.service.ServicesClientOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class UnitTests {

    @Test
    public void testAjoutClient() {
        ServicesClientOrder service = new ServicesClientOrder();
        Client client = new Client();
        client.setFirstName("Alain");
        client.setLastName("Delon");
        service.addClient(client);

        Assertions.assertEquals(1, service.getAllClients().size());
    }

    @Test
    public void testFindClient() {
        ServicesClientOrder service = new ServicesClientOrder();
        Client client = new Client();
        client.setFirstName("Alain");
        client.setLastName("Delon");
        service.addClient(client);

        Assertions.assertNotNull(service.findClientById(1L).get());
    }

    @Test
    public void deleteClient() {
        ServicesClientOrder service = new ServicesClientOrder();
        Client client = new Client();
        client.setFirstName("Alain");
        client.setLastName("Delon");
        service.addClient(client);

        Assertions.assertEquals(1, service.getAllClients().size());
        service.deleteClient(1L);
        Assertions.assertEquals(0, service.getAllClients().size());
        Assertions.assertEquals(false, service.findClientById(1L).isPresent());
    }

    @Test
    public void updateClient() {
        ServicesClientOrder service = new ServicesClientOrder();
        Client client = new Client();
        client.setFirstName("Alain");
        client.setLastName("Delon");
        service.addClient(client);


        Long id = client.getId();
        Client newDataClient = new Client();
        newDataClient.setId(id);
        newDataClient.setFirstName("Alain");
        newDataClient.setLastName("Prost");

        service.updateClient(newDataClient);

        Optional<Client> oc = service.findClientById(id);
        if(oc.isPresent()) {
            Client updatedClient = oc.get();
            Assertions.assertEquals("Prost", updatedClient.getLastName());
        } else {
            Assertions.fail();
        }
    }
}