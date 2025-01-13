package org.sid.orderservice.models;

import jakarta.persistence.ElementCollection;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String image;
    private String color;
    private String brand;
    private String category;
    private String description;
    int size;
}