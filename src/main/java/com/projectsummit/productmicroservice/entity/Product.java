package com.projectsummit.productmicroservice.entity;

public class Product {

    private String productName;
    private Integer productPrice;
    private String procutCategory;

    private String productDescription;

    private String productImageUrl;

    public Product() {
    }

    public Product(String productName, Integer productPrice, String procutCategory, String productDescription, String productImageUrl) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.procutCategory = procutCategory;
        this.productDescription = productDescription;
        this.productImageUrl = productImageUrl;
    }

    public Product(String productName, Integer productPrice, String procutCategory, String productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.procutCategory = procutCategory;
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
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
