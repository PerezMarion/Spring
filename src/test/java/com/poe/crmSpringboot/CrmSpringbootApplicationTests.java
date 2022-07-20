package com.poe.crmSpringboot;

import com.poe.crmSpringboot.business.Client;
import com.poe.crmSpringboot.business.service.ServicesClientOrder;
import com.poe.crmSpringboot.dao.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CrmSpringbootApplicationTests {

	// Ici pas besoin de faire Service service = new Service() grace à l'anotation
	@Autowired
    ServicesClientOrder service;

	@Autowired
	ClientRepository clientRepository;

	@Test
	void contextLoads() {

		Client client = new Client();
		client.setFirstName("Alain");
		client.setLastName("Delon");
		service.addClient(client);

		Assertions.assertEquals(1, service.getAllClients().size());
	}

	@Test
	void testClientRepository() {
		List<Client> sqlClients = clientRepository.findAll();
		Assertions.assertTrue(sqlClients.size() > 0);
	}
}
