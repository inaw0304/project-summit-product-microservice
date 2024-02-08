package com.projectsummit.productmicroservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
    private String category;
    private String description;
    private String imageUrl;
    private Long productOwnerId;
    private boolean adminApproval;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    // constructors

    // default constructor
    public Product() {
    }

    // all parameter constructor
    public Product(Long id, String name, Float price, String category, String description, String imageUrl, Long productOwnerId, boolean isAdminApproved, LocalDate createdDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.imageUrl = imageUrl;
        this.productOwnerId = productOwnerId;
        this.adminApproval = isAdminApproved;
        this.createdDate = createdDate;
    }

    // all parameters(without id) constructor
    public Product(String name, Float price, String category, String description, String imageUrl, Long productOwnerId, boolean isAdminApproved, LocalDate createdDate) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.imageUrl = imageUrl;
        this.productOwnerId = productOwnerId;
        this.adminApproval = isAdminApproved;
        this.createdDate = createdDate;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getProductOwnerId() {
        return productOwnerId;
    }

    public void setProductOwnerId(Long productOwnerId) {
        this.productOwnerId = productOwnerId;
    }

    public boolean isAdminApproval() {
        return adminApproval;
    }

    public void setAdminApproval(boolean adminApproval) {
        this.adminApproval = adminApproval;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    // toString Method
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", productOwnerId=" + productOwnerId +
                ", adminApproval=" + adminApproval +
                ", createdDate=" + createdDate +
                '}';
    }
}
