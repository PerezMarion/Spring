package com.poe.crmSpringboot;

import com.poe.crmSpringboot.business.Client;
import com.poe.crmSpringboot.business.Order;
import com.poe.crmSpringboot.business.service.ServicesClientOrder;
import com.poe.crmSpringboot.dao.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class CrmSpringbootApplicationTests {

	// Ici pas besoin de faire ClientRepository clientRepository = new ClientRepository() grace à l'annotation
	@Autowired
	ClientRepository clientRepository;


	@Test
	void testClientRepository() {
		List<Client> sqlClients = clientRepository.findAll();
		Assertions.assertTrue(sqlClients.size() > 0);
	}

	@Test
	void testFindAllClientsByCompanyName() {
		List<Client> clientsGoogle = clientRepository.findAllClientsByCompanyName("Google");
		Assertions.assertTrue(clientsGoogle.size() > 0);
		for(Client client: clientsGoogle){
			System.out.println(client);
		}
	}

	@Test
	void testFindAllClientsByFistNameAndLastName() {
		List<Client> clientsGoogle = clientRepository.
				findAllClientsByFirstNameAndLastName("Fabrice", "Martin");
		Assertions.assertTrue(clientsGoogle.size() > 0);
		for(Client client: clientsGoogle){
			System.out.println(client);
		}
	}

	@Test
	void testOneToMany() {
		Optional<Client> oc = clientRepository.findById(1L);
		if(oc.isPresent()) {
			Client client = oc.get();
			for(Order order : client.getOrders()) {
				System.out.println(order);
			}
		}
	}
}