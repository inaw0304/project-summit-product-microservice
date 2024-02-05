package com.projectsummit.productmicroservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

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
    private String productCategory;

    private String productDescription;

    private String productImageUrl;

    private Long productOwnerId;

    private boolean isAdminApproved;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    public Product() {
    }

    // all parameter constructor
    public Product(Long id, String productName, Float productPrice, String productCategory, String productDescription, String productImageUrl, Long productOwnerId, boolean isAdminApproved) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productImageUrl = productImageUrl;
        this.productOwnerId = productOwnerId;
        this.isAdminApproved = isAdminApproved;
        this.createdDate = LocalDate.now();
    }

    // all parameter constructor without id
    public Product(String productName, Float productPrice, String productCategory, String productDescription, String productImageUrl, Long productOwnerId, boolean isAdminApproved, LocalDate createdDate) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productImageUrl = productImageUrl;
        this.productOwnerId = productOwnerId;
        this.isAdminApproved = isAdminApproved;
        this.createdDate = createdDate;
    }

    // all parameter constructor without id and isAdminApproved
    public Product(String productName, Float productPrice, String productCategory, String productDescription, String productImageUrl, Long productOwnerId, LocalDate createdDate) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productImageUrl = productImageUrl;
        this.productOwnerId = productOwnerId;
        this.createdDate = createdDate;
    }

    // all parameter constructor without id and createdDate
    public Product(String productName, Float productPrice, String productCategory, String productDescription, String productImageUrl, Long productOwnerId, boolean isAdminApproved) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productImageUrl = productImageUrl;
        this.productOwnerId = productOwnerId;
        this.isAdminApproved = isAdminApproved;
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

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Long getProductOwnerId() {
        return productOwnerId;
    }

    public void setProductOwnerId(Long productOwnerId) {
        this.productOwnerId = productOwnerId;
    }

    public boolean isAdminApproved() {
        return isAdminApproved;
    }

    public void setAdminApproved(boolean adminApproved) {
        isAdminApproved = adminApproved;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", procutCategory='" + productCategory + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productImageUrl='" + productImageUrl + '\'' +
                ", productOwnerId=" + productOwnerId +
                ", isAdminApproved=" + isAdminApproved +
                ", createdDate=" + createdDate +
                '}';
    }
}
