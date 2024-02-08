package com.projectsummit.productmicroservice.controller;


import com.projectsummit.productmicroservice.dto.ProductCreatePatchDeleteResponse;
import com.projectsummit.productmicroservice.entity.Product;
import com.projectsummit.productmicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productServiceImpl){
        this.productService = productServiceImpl;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return this.productService.getProducts();
    }

    @GetMapping("/products/{productId}")
    public Optional<Product> getProductById(@PathVariable("productId") Long productId){
        return productService.getProduct(productId);
    }

    @PostMapping("/products")
    public ProductCreatePatchDeleteResponse createNewProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PatchMapping("/products/{productId}")
    public ProductCreatePatchDeleteResponse updateProduct(@PathVariable("productId") Long productId,@RequestBody Product product){
        return productService.updateProduct(productId,product);
    }

    @DeleteMapping("/products/{productId}")
    public ProductCreatePatchDeleteResponse deleteProduct(@PathVariable("productId") Long productId){
        return productService.deleteProduct(productId);
    }

}
