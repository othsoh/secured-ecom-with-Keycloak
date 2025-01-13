package org.sid.inventoryservice.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Product {
    @Id
    String id;
    String name;
    double price;
    int quantity;
    String image;
    String color;
    String brand;
    String category;
    String description;
    int size;
}
