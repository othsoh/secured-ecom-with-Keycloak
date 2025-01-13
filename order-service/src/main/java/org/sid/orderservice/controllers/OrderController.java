package org.sid.orderservice.controllers;

import org.sid.orderservice.entities.Order;
import org.sid.orderservice.models.Product;
import org.sid.orderservice.repositories.OrderRepository;
import org.sid.orderservice.restClients.InventoryRestClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    OrderRepository orderRepository;
    InventoryRestClient inventoryRestClient;

    public OrderController(OrderRepository orderRepository, InventoryRestClient inventoryRestClient) {
        this.orderRepository = orderRepository;
        this.inventoryRestClient = inventoryRestClient;
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {

        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        order.getProductItems().forEach(productItem -> {
            Product product = inventoryRestClient.getProductById(productItem.getProductId());
            productItem.setProduct(product);
        });
        return ResponseEntity.ok(order);
    }


}
