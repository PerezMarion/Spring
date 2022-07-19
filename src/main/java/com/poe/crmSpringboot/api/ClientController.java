package com.poe.crmSpringboot.api;

import com.poe.crmSpringboot.business.Client;
import com.poe.crmSpringboot.business.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// Controller équivalent Api d'où packages api
@RestController
public class ClientController {

    @Autowired
    Service service;

    @GetMapping("clients")
    public List<Client> getAll() {

        return service.getAllClients();
    }
}