package com.projectsummit.productmicroservice.service;

import com.projectsummit.productmicroservice.controller.ProductNotFoundException;
import com.projectsummit.productmicroservice.dao.ProductDAO;
import com.projectsummit.productmicroservice.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    public List<Product> getProducts(){
        return productDAO.findAll();
    }

    public Optional<Product> getProduct(Long productId){

        boolean exists = productDAO.existsById(productId);

        if(!exists){
            throw new ProductNotFoundException("Product not found - "+ productId);
        }

        Optional<Product> product = productDAO.findById(productId);
        return product;
    }

    @Transactional
    public void saveNewProductInDB(Product product) {
        productDAO.save(product);
    }

    @Transactional
    public void deleteProduct(Long productId) {

        boolean exists = productDAO.existsById(productId);

        if(!exists){
            throw new ProductNotFoundException("Product not found - "+ productId);
        }

        productDAO.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, String productName, String category, String description, String productImageUrl, boolean isAdminApproved, Float price) {

        boolean exists = productDAO.existsById(productId);

        if(!exists){
            throw new ProductNotFoundException("Product not found - "+ productId);
        }

        Optional<Product> product = productDAO.findById(productId);
        if(product.isPresent()){
            product.get().setProductName(productName);
            product.get().setProductCategory(category);
            product.get().setProductDescription(description);
            product.get().setProductImageUrl(productImageUrl);
            product.get().setAdminApproved(isAdminApproved);
            product.get().setProductPrice(price);
        }

    }

}
