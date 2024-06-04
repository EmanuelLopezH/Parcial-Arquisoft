package com.example.parcial.Service;

import com.example.parcial.Model.Order;
import com.example.parcial.JPA.OrderJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderJPA orderJPA;

    public List<Order> getAllOrders() {
        return orderJPA.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderJPA.findById(id);
    }

    public void saveOrder(Order order) {
        orderJPA.save(order);
    }

    public Order updateOrder(Order order) {
        Order updatedOrder = orderJPA.findById(order.getOrderId()).orElse(null);
        updatedOrder.setClientId(order.getClientId());
        updatedOrder.setStatus(order.getStatus());
        updatedOrder.setDeliveryDate(order.getDeliveryDate());
        updatedOrder.setAddress(order.getAddress());
        return orderJPA.save(updatedOrder);
    }

    public void deleteOrderById(Long id) {
        orderJPA.deleteById(id);
    }
}
