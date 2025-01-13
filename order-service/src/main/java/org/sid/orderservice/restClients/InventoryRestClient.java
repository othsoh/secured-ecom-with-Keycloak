package org.sid.orderservice.restClients;

import org.sid.orderservice.entities.ProductItem;
import org.sid.orderservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "INVENTORY-SERVICE", url = "http://localhost:8087")
public interface InventoryRestClient {
    @GetMapping("/api/products")
    List<Product> getAllProducts();

    @GetMapping("/api/products/{id}")
    Product getProductById(@PathVariable String id);

    @GetMapping("/api/products/{id}/productItems")
    List<ProductItem> getProductItems(@PathVariable String id);

}
