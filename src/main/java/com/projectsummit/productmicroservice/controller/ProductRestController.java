package com.projectsummit.productmicroservice.controller;


import com.projectsummit.productmicroservice.entity.Product;
import com.projectsummit.productmicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return this.productService.getProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable int productId){

        if(productId>=this.productService.getProducts().size() || productId < 0){
            throw new ProductNotFoundException("Product not found - "+ productId);
        }

        return this.productService.getProducts().get(productId);
    }

}
