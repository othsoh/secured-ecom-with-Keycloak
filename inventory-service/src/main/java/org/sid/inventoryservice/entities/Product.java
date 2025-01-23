package org.sid.inventoryservice.entities;

import jakarta.persistence.*;
import lombok.*;

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
    long discount = 0;
    int size;
    double discountedPrice;
    double rating ;

    @PrePersist
    @PreUpdate
    public void calculateDiscountedPrice() {
        this.discountedPrice = price - (price * discount / 100);
    }

    public void setRating(long rating) {
        if (rating < 0) {
            this.rating = 0;
        } else if (rating > 5) {
            this.rating = 5;
        } else {
            this.rating = rating;
        }
    }
}