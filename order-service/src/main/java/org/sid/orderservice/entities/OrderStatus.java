package org.sid.orderservice.entities;

import java.util.Random;

public enum OrderStatus {
    PENDING, CONFIRMED, SHIPPED,DELIVERED, CANCELLED;
    private static final Random RANDOM = new Random();

    public static OrderStatus getRandomOrderStatus() {
        OrderStatus[] statuses = OrderStatus.values();
        return statuses[RANDOM.nextInt(statuses.length)];
    }
}
