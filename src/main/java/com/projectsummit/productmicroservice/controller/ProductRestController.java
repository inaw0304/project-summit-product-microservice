package com.projectsummit.productmicroservice.controller;


import com.projectsummit.productmicroservice.entity.Product;
import com.projectsummit.productmicroservice.service.ProductService;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


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

    @PostMapping("/products")
    public void saveNewProduct(@RequestBody Product product){
        productService.saveNewProductInDB(product);
    }

    @GetMapping("/products/{productId}")
    public Optional<Product> getProductById(@PathVariable("productId") Long productId){
        return productService.getProduct(productId);
    }

    @PutMapping("/products/{productId}")
    public void updateProduct(@PathVariable("productId") Long productId,
                              @RequestParam(required = false)String productName,
                              @RequestParam(required = false)String category,
                              @RequestParam(required = false)String description,
                              @RequestParam(required = false)String productImageUrl,
                              @RequestParam(required = false)boolean isAdminApproved,
                              @RequestParam(required = false)Float price){

        productService.updateProduct(productId,productName,category,description,productImageUrl,isAdminApproved,price);

    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
    }

}
