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
	void testClientRepository() {
		List<Client> sqlClients = clientRepository.findAll();
		Assertions.assertTrue(sqlClients.size() > 0);
	}

	@Test
	void testFindAllClientByCompanyName() {
		List<Client> clientsGoogle = clientRepository.findAllClientByCompanyName("Google");
		Assertions.assertTrue(clientsGoogle.size() > 0);
		for(Client client: clientsGoogle){
			System.out.println(client);
		}
	}

	@Test
	void testFindAllClientByFistNameAndLastName() {
		List<Client> clientsGoogle = clientRepository.
				findAllClientByFirstNameAndLastName("Fabrice", "Martin");
		Assertions.assertTrue(clientsGoogle.size() > 0);
		for(Client client: clientsGoogle){
			System.out.println(client);
		}
	}
}