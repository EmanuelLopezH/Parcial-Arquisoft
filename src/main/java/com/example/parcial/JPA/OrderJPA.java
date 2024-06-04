package com.example.parcial.JPA;

import com.example.parcial.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJPA extends JpaRepository<Order, Long> {
}
