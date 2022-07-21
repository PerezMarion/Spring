package com.poe.crmSpringboot.business;

import javax.persistence.*;

// Classe avec code métier d'où le package business
@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // On doit rajouter cette annotation car il y a une auto conversion de companyName (camelCase) en
    // company_name (snake_case) qui est normalement la bonne écriture pour une colonne de base de données
    // (mais là on a (malheureusement) gardé le camelCase dans la bdd)
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    private String email;
    private String phone;
    private String address;
    @Column(name = "zipCode")
    private String zipCode;
    private String city;
    private String country;

    private ClientState state;

    public Client() {
    }

    public Client(String companyName, String firstName, String lastName, String email, String phone,
                  String address, String zipCode, String city, String country, ClientState state) {
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.state = state;
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

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", companyName='" + companyName + '\'' + ", firstName='" + firstName
                + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", phone='" + phone
                + '\'' + ", address='" + address + '\'' + ", zipCode='" + zipCode + '\'' + ", city='" + city
                + '\'' + ", country='" + country + '\'' + ", state='" + state + '}';
    }
}