package com.poe.crmSpringboot;

import com.poe.crmSpringboot.business.Client;
import com.poe.crmSpringboot.business.service.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTests {

    @Test
    void testAjoutClient() {
        Service service = new Service();
        Client client = new Client();
        client.setFirstName("Alain");
        client.setLastName("Delon");
        service.addClient(client);

        Assertions.assertEquals(1, service.getAllClients().size());
    }
}
