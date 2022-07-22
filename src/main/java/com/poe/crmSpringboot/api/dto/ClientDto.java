package com.poe.crmSpringboot.api.dto;

import com.poe.crmSpringboot.business.Client;
import com.poe.crmSpringboot.business.ClientState;
import com.poe.crmSpringboot.business.Order;
import java.util.List;

// Dto = data transfert objet
// Modèle indépendant qui définit la façon dont les données seront envoyées sur le réseau
// Permet de ne pas exposer les entités de la base de données au client qui ne recevra plus de données
// Correspondant directement à la bdd mais une forme modifiée
// En lien avec la classe ClientMapper qui permet de transformer un clientDto en client et inversement
public class ClientDto {

    private Long id;
    private String companyName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String zipCode;
    private String city;
    private String country;
    private ClientState state;
    private List<Order> orders;
    private float totalExpense;

    public ClientDto(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ClientState getState() {
        return state;
    }

    public void setState(ClientState state) {
        this.state = state;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public float getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(float totalExpense) {
        this.totalExpense = totalExpense;
    }

    @Override
    public String toString() {
        return "ClientDto{" + "id=" + id + ", companyName='" + companyName + '\'' +
                ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' + ", phone='" + phone + '\'' + ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' + ", city='" + city + '\'' + ", country='" + country + '\'' +
                ", state=" + state + ", orders=" + orders + ", totalExpense=" + totalExpense + '}';
    }
}