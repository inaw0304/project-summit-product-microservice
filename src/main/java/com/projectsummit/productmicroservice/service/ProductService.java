package com.projectsummit.productmicroservice.service;

import com.projectsummit.productmicroservice.dto.ProductCreatePatchDeleteResponse;
import com.projectsummit.productmicroservice.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> getProducts();
    public Optional<Product> getProduct(Long productId);
    public ProductCreatePatchDeleteResponse createProduct(Product product);
    public ProductCreatePatchDeleteResponse updateProduct(Long productId, Product product);
    public ProductCreatePatchDeleteResponse deleteProduct(Long productId);
}
