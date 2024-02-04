package com.projectsummit.productmicroservice.controller;


import com.projectsummit.productmicroservice.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductRestController {

    private List<Product> products;

    @PostConstruct
    public void loadProducts(){
        this.products = new ArrayList<>();
        products.add(new Product("Iphone14ProMax",1000,"Electronics","This is an IPhone 14 Pro Max by Apple","www.url_iphone14promax.com"));
        products.add(new Product("Apple",2,"Fruits and Vegetables","Red apples by Sysco","www.url_apple.com"));
        products.add(new Product("Bed",100,"Furnitures","This is one of the best beds in the world!","www.url_bed.com"));
        products.add(new Product("ToothPaste",34,"Home Essentials","Buy this and get white teeth","www.url_toothpaste.com"));
        products.add(new Product("Paricatamol",12,"Medicine","This is medicine","www.url_medicine.com"));
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return this.products;
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable Integer productId){
        return this.products.get(productId);
    }


}
