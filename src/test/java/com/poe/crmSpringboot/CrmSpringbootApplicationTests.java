package com.poe.crmSpringboot;

import com.poe.crmSpringboot.business.Client;
import com.poe.crmSpringboot.business.service.ServicesClientOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrmSpringbootApplicationTests {

	// Ici pas besoin de faire Service service = new Service() grace à l'anotation
	@Autowired
    ServicesClientOrder service;

	@Test
	void contextLoads() {

		Client client = new Client();
		client.setFirstName("Alain");
		client.setLastName("Delon");
		service.addClient(client);

		Assertions.assertEquals(1, service.getAllClients().size());
	}

}
