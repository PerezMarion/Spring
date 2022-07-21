package com.poe.crmSpringboot.api;

import com.poe.crmSpringboot.business.Order;
import com.poe.crmSpringboot.business.service.ServicesClientOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class OrderController {

    @Autowired
    ServicesClientOrder service;

    @GetMapping("orders")
    public List<Order> getAllOrders() {

        return service.getAllOrders();
    }

    @GetMapping("orders/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable("id") Long id) {

        Optional<Order> oo = service.findOrderById(id);
        if (oo.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(oo.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
    }

    @PostMapping("orders")
    public void addOrder(@RequestBody Order order) {
        service.addOrder(order);
    }

    @DeleteMapping("orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id) {

        if (service.deleteOrder(id) == true) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("L'identifiant ne correspond à aucune commande");
        }
    }

    @PutMapping("orders/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {

        if (!id.equals(order.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body("L'identifiant dans l'url ne correspond pas à l'identifiant dans le body");
        } else {
            if (service.updateOrder(order) == true) {
                return ResponseEntity.status(HttpStatus.OK).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).
                        body("Lidentifiant ne correspond à aucune commande");
            }
        }
    }
}