package com.projectsummit.productmicroservice.config;

import com.projectsummit.productmicroservice.dao.ImageUrlDAO;
import com.projectsummit.productmicroservice.dao.ProductDAO;
import com.projectsummit.productmicroservice.entity.ImageUrl;
import com.projectsummit.productmicroservice.entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class PopulateDB {

    @Bean
    CommandLineRunner commandLineRunner(ProductDAO productDAO, ImageUrlDAO imageUrlDAO){

        return args -> {
            LocalDate today = LocalDate.now();
            List<Product> products = new ArrayList<>();
            products.add(new Product("Iphone14ProMax", 1000.0F,"Electronics","This is an IPhone 14 Pro Max by Apple",1L,true,today));
            products.add(new Product("Apple",2.0F,"Fruits and Vegetables","Red apples by Sysco",2L,true,today));
            products.add(new Product("Bed",100.0F,"Furniture","This is one of the best beds in the world!",2L,false,today));
            products.add(new Product("ToothPaste",34.5F,"Home Essentials","Buy this and get white teeth",3L,true,today));
            products.add(new Product("Paracitamol",12.5F,"Medicine","This is medicine",4L,true,today));
            productDAO.saveAll(products);

            List<ImageUrl> imageUrls = new ArrayList<>();
            imageUrls.add(new ImageUrl("www.imageUrl1.com",true,1L));
            imageUrls.add(new ImageUrl("www.imageUrl2.com",true,1L));
            imageUrls.add(new ImageUrl("www.imageUrl3.com",true,2L));
            imageUrls.add(new ImageUrl("www.imageUrl4.com",true,2L));
            imageUrls.add(new ImageUrl("www.imageUrl5.com",true,3L));
            imageUrlDAO.saveAll(imageUrls);

        };

    }

}
