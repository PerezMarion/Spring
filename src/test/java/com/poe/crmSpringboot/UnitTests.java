package com.poe.crmSpringboot;

import com.poe.crmSpringboot.business.Client;
import com.poe.crmSpringboot.business.service.ServicesClientOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}