package com.projectsummit.productmicroservice.config;

import com.projectsummit.productmicroservice.dao.ProductDAO;
import com.projectsummit.productmicroservice.entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AddProducts {

    @Bean
    CommandLineRunner commandLineRunner(ProductDAO productDAO){

        return args -> {
            LocalDate today = LocalDate.now();
            List<Product> products = new ArrayList<>();
            products.add(new Product("Iphone14ProMax", 1000.0F,"Electronics","This is an IPhone 14 Pro Max by Apple","www.url_iphone14promax.com",1L,true,today));
            products.add(new Product("Apple",2.0F,"Fruits and Vegetables","Red apples by Sysco","www.url_apple.com",2L,true,today));
            products.add(new Product("Bed",100.0F,"Furniture","This is one of the best beds in the world!","www.url_bed.com",2L,false,today));
            products.add(new Product("ToothPaste",34.5F,"Home Essentials","Buy this and get white teeth","www.url_toothpaste.com",3L,true,today));
            products.add(new Product("Paracitamol",12.5F,"Medicine","This is medicine","www.url_medicine.com",4L,true,today));
            productDAO.saveAll(products);
        };

    }

}
