package com.projectsummit.productmicroservice.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @SequenceGenerator(
            name="product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;

    private String productName;
    private Float productPrice;
    private String procutCategory;

    private String productDescription;

    private String productImageUrl;

    public Product() {
    }

    public Product(String productName, Float productPrice, String procutCategory, String productDescription, String productImageUrl) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.procutCategory = procutCategory;
        this.productDescription = productDescription;
        this.productImageUrl = productImageUrl;
    }

    public Product(String productName, Float productPrice, String procutCategory, String productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.procutCategory = procutCategory;
        this.productDescription = productDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProcutCategory() {
        return procutCategory;
    }

    public void setProcutCategory(String procutCategory) {
        this.procutCategory = procutCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }
}
