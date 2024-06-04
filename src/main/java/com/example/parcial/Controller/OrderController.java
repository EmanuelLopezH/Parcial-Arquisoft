package com.example.parcial.Controller;

import com.example.parcial.Model.Client;
import com.example.parcial.Model.Order;
import com.example.parcial.Service.OrderService;
import com.example.parcial.Service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@CrossOrigin
@Tag(name = "Ordenes")
@Api(value = "Sistema de gestion de ordenes", description = "Operaciones para las ordenes.")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    @ApiOperation(value = "Ver lista de ordenes")
    @GetMapping(value = "/orders", produces = "application/vnd.api+json;version=v1")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

//    @ApiOperation(value = "Buscar Orden")
//    @GetMapping(value = "/{orderId}", produces = "application/vnd.api+json;version=v1")
//    public Optional<Order> searchOrder(@PathVariable Long orderId) {
//        return orderService.getOrderById(orderId);
//    }
@ApiOperation(value = "Ver una orden por Id")
    @GetMapping("/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrder(@PathVariable Long orderId) {
        Optional<Order> orderOpt = orderService.getOrderById(orderId);

        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            Optional<Client> clientOpt = clientService.getClientById(order.getClientId());

            if (clientOpt.isPresent()) {
                Client client = clientOpt.get();
                Map<String, Object> response = new HashMap<>();
                response.put("status", order.getStatus());
                response.put("customerName", client.getFirstName() + " " + client.getLastName());
                response.put("deliveryAddress", order.getAddress());
                response.put("estimatedDelivery", order.getDeliveryDate());

                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(404).body(Map.of("message", "Cliente no encontrado"));
            }
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "Pedido no encontrado"));
        }
    }


    @ApiOperation(value = "Guardar orden")
    @PostMapping(value = "order", consumes = "application/vnd.api+json;version=v1")
    public void saveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    @ApiOperation(value = "Eliminar orden")
    @DeleteMapping(value = "/{orderId}", consumes = "application/vnd.api+json;version=v1")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrderById(orderId);
    }
}
