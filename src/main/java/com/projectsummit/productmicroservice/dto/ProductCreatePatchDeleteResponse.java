package com.projectsummit.productmicroservice.dto;

import com.projectsummit.productmicroservice.entity.Product;

import java.util.Optional;

public class ProductCreatePatchDeleteResponse {

    private String status;
    private Optional<Product> product;

    public ProductCreatePatchDeleteResponse() {
    }

    public ProductCreatePatchDeleteResponse(String status, Optional<Product> deletedProduct) {
        this.status = status;
        this.product = deletedProduct;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Optional<Product> getProduct() {
        return product;
    }

    public void setProduct(Optional<Product> product) {
        this.product = product;
    }


    @Override
    public String toString() {
        return "ProductDeleteResponse{" +
                "status='" + status + '\'' +
                ", product=" + product +
                '}';
    }
}
