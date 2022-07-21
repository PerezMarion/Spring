package com.poe.crmSpringboot.dao;

import com.poe.crmSpringboot.business.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> { }