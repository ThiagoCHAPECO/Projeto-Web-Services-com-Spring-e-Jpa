package com.educandoweb.demo.config;


import com.educandoweb.demo.entities.*;
import com.educandoweb.demo.entities.enums.OrderStatus;
import com.educandoweb.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Computers");

        Product p1 = new Product(null, "The lord of the rings", "Lorem ipsum", 90.8, "");
        Product p2 = new Product(null, "The king of the kings", "Lorem", 89.9, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);

        productRepository.saveAll(Arrays.asList(p1, p2));

        User user1 = new User(null, "Thiago gimenes", "thiago@gmail.com", "99998989", "123456");
        User user2 = new User(null, "Vinicius Vilela", "vilela@gmail.com", "98998989", "123456789");



        Order o1 = new Order(null, Instant.parse("2019-06-20T19:07:00Z"), OrderStatus.PAID,  user1);
        Order o2 = new Order(null, Instant.parse("2019-06-21T19:09:00Z"), OrderStatus.DELIVERED, user2);



        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(o1, o2));

        OrderItem oi1 = new OrderItem(o1, p2, 2, p2.getPrice());
        OrderItem oi2 = new OrderItem(o2, p1, 4, p1.getPrice());


        orderItemRepository.saveAll(Arrays.asList(oi1, oi2));
    }
}
