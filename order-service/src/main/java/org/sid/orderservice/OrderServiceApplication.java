package org.sid.orderservice;

import org.sid.orderservice.entities.Order;
import org.sid.orderservice.entities.OrderStatus;
import org.sid.orderservice.entities.ProductItem;
import org.sid.orderservice.repositories.OrderRepository;
import org.sid.orderservice.repositories.ProductItemRepository;
import org.sid.orderservice.restClients.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InventoryRestClient inventoryRestClient, OrderRepository orderRepository, ProductItemRepository productItemRepository) {
        return args -> {

            for (int i = 0; i < 5; i++) {
                Order order = Order.builder()
                        .id(UUID.randomUUID().toString())
                        .date(LocalDate.now())
                        .status(OrderStatus.getRandomOrderStatus()).build();
                Order savedOrder = orderRepository.save(order);

                inventoryRestClient.getAllProducts().forEach(product -> {
                    productItemRepository.save(ProductItem.builder()
                            .productId(product.getId())
                            .quantity(1 + new Random().nextInt(4))
                            .price(product.getPrice())
                            .order(savedOrder).build());
                });

            }

        };
    }
}
