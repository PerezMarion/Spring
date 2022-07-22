package com.poe.crmSpringboot.api.dto;

import com.poe.crmSpringboot.business.Client;

public class ClientMapper {

    public static ClientDto convertClientToClientDto(Client client) {

        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setCompanyName(client.getCompanyName());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setEmail(client.getEmail());
        dto.setPhone(client.getPhone());
        dto.setAddress(client.getAddress());
        dto.setZipCode(client.getZipCode());
        dto.setCity(client.getCity());
        dto.setCountry(client.getCountry());
        dto.setState(client.getState());
        dto.setOrders(client.getOrders());
        return dto;
    }

    public static Client convertClientDtoToClient(ClientDto clientDto) {

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setCompanyName(clientDto.getCompanyName());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        client.setAddress(clientDto.getAddress());
        client.setZipCode(clientDto.getZipCode());
        client.setCity(clientDto.getCity());
        client.setCountry(clientDto.getCountry());
        client.setState(clientDto.getState());
        client.setOrders(clientDto.getOrders());
        return client;
    }
}