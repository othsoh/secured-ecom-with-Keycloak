package org.sid.inventoryservice.controllers;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@PreAuthorize("hasAuthority('ADMIN')")
public class ProductRestController {

    ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")

    List<Product> products() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    Product productById(@PathVariable String id) {
        return productRepository.findById(id).orElse(null);
    }

    @GetMapping("/auth")
    Authentication authentication(Authentication authentication) {
        return authentication;
    }



}
