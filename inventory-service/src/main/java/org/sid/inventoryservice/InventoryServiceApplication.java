package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.saveAll(
                    List.of(
                            Product.builder().id("P01").name("Nike Air Max Plus").image("https://static.nike.com/a/images/t_PDP_936_v1/f_auto,q_auto:eco/b9739f66-98f6-42a7-8fe6-6b25ef0b9d83/NIKE+AIR+MAX+PLUS.png").color("Black/Baltic Blue/Photo").price(1999).brand("Nike").rating(new Random().nextInt(11) / 2.0).size(41).quantity(10).build(),
                            Product.builder().id("P02").name("Nike SNKRS").image("https://static.nike.com/a/images/t_prod_pc/w_960,c_limit,q_auto,f_auto/950dffd2-a3f4-4896-a221-23aa7b6b3086/date-de-sortie-de-la-nike-air-max-plus-%C2%AB%C2%A0moonlight%C2%A0%C2%BB-avec-cristaux-swarovski%C2%AE-pour-femme-fz4237-001.jpg").color("Moonlight").rating(new Random().nextInt(11) / 2.0).size(37).brand("Nike").price(4499).discount(12).quantity(20).build(),
                            Product.builder().id("P03").name("Nike SB Dunk Low Pro").image("https://static.nike.com/a/images/w_1280,q_auto,f_auto/9f9fe870-473f-4eab-bd5f-b3f89735556c/date-de-sortie-de-la-nike-sb-dunk-low-pro-%C2%AB%C2%A0black-and-smoke-grey%C2%A0%C2%BB-hf3063-001.jpg").color("Black and Smoke Grey").brand("Nike").rating(new Random().nextInt(11) / 2.0).size(43).price(1199).discount(10).quantity(7).build(),
                            Product.builder().id("P04").name("Air Jordan 3 Black Cat").image("https://static.nike.com/a/images/w_1280,q_auto,f_auto/fde499fa-6949-454d-8c74-6f590116f071/date-de-sortie-de-la-air-jordan%C2%A03-%C2%AB%C2%A0black-cat%C2%A0%C2%BB-ct8532-001.jpg").color("Black").brand("Nike").price(2099).rating(new Random().nextInt(11) / 2.0).size(42).quantity(7).build(),
                            Product.builder().id("P05").name("Air Jordan 1 x Travis Scott").image("https://static.nike.com/a/images/w_1280,q_auto,f_auto/d04a34a0-f36d-4b75-bdb7-ae4196796efb/date-de-sortie-de-la-air-jordan%C2%A01%C2%A0x-travis-scott-%C2%AB%C2%A0velvet-brown-and-dark-mocha%C2%A0%C2%BB-dm7866-202.jpg").color("Velvet Brown and Dark Mocha").brand("Nike").rating(new Random().nextInt(11) / 2.0).size(41).price(1599).quantity(7).build()
                    ));
        };
    }

}
