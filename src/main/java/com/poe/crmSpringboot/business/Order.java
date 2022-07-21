package com.poe.crmSpringboot.business;

import javax.persistence.*;

// Classe avec code métier d'où le package business
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tpePresta")
    private String typePresta;
    private String designation;
    @Column(name = "nbDays")
    private int nbDays;
    @Column(name = "unitPrice")
    private float unitPrice;
    private OrderState state;

    public Order() {
    }

    public Order(Long id, String typePresta, String designation, int nbDays, float unitPrice, OrderState state) {
        this.id = id;
        this.typePresta = typePresta;
        this.designation = designation;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getNbDays() {
        return nbDays;
    }

    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", typePresta='" + typePresta + '\'' + ", designation='" + designation
                + '\'' + ", nbDays=" + nbDays + ", unitPrice=" + unitPrice + ", state=" + state + '}';
    }
}