package com.example.parcial.Controller;
import com.example.parcial.Model.Order;
import com.example.parcial.Service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @ApiOperation(value = "Ver lista de ordenes")
    @GetMapping(value = "/orders", produces = "application/vnd.api+json;version=v1")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @ApiOperation(value = "Buscar Orden")
    @GetMapping(value = "/{orderId}", produces = "application/vnd.api+json;version=v1")
    public Optional<Order> getOrder(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
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
