package com.projectsummit.productmicroservice.service;

import com.projectsummit.productmicroservice.controller.ProductNotFoundException;
import com.projectsummit.productmicroservice.dao.ProductDAO;
import com.projectsummit.productmicroservice.dto.ProductCreatePatchDeleteResponse;
import com.projectsummit.productmicroservice.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO){
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
    public ProductCreatePatchDeleteResponse createProduct(Product product) {
        productDAO.save(product);
        return new ProductCreatePatchDeleteResponse("success",productDAO.findById(product.getId()));
    }

    @Transactional
    public ProductCreatePatchDeleteResponse updateProduct(Long productId, Product product) {

        if(product.getId()!=null){
//            throw new Exception("")
        }


        boolean exists = productDAO.existsById(productId);

        if(!exists){
            throw new ProductNotFoundException("Product not found - "+ productId);
        }

        Optional<Product> foundProduct = productDAO.findById(productId);
        if(foundProduct.isPresent()){
            if(product.getName()!=null){
                foundProduct.get().setName(product.getName());
            }

            if(product.getCategory()!=null){
                foundProduct.get().setCategory(product.getCategory());
            }

            if(product.getPrice()!=null){
                foundProduct.get().setPrice(product.getPrice());
            }

            if(product.getDescription()!=null){
                foundProduct.get().setDescription(product.getDescription());
            }

            if(product.getProductOwnerId()!=null){
                foundProduct.get().setProductOwnerId(product.getProductOwnerId());
            }

            if(product.getCreatedDate()!=null){
                foundProduct.get().setCreatedDate(product.getCreatedDate());
            }

            foundProduct.get().setAdminApproval(false);
        }else{
            throw new ProductNotFoundException("Product not found - "+ productId);
        }

        return new ProductCreatePatchDeleteResponse("success",foundProduct);

    }

    @Transactional
    public ProductCreatePatchDeleteResponse deleteProduct(Long productId) {

        boolean exists = productDAO.existsById(productId);

        if(!exists){
            throw new ProductNotFoundException("Product not found - "+ productId);
        }

        Optional<Product> product = productDAO.findById(productId);

        productDAO.deleteById(productId);

        return new ProductCreatePatchDeleteResponse("success",product);
    }

}
