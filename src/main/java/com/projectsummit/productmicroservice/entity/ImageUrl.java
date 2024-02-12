package com.projectsummit.productmicroservice.entity;

import jakarta.persistence.*;

@Entity
@Table
public class ImageUrl {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private Long productId;

    private boolean adminApproval;

    public ImageUrl() {
    }

    // all constructor
    public ImageUrl(Long id, String imageUrl, boolean adminApproval,Long productId) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.adminApproval = adminApproval;
        this.productId = productId;
    }

    //constructor without id

    public ImageUrl(String imageUrl, boolean adminApproval,Long productId) {
        this.imageUrl = imageUrl;
        this.adminApproval = adminApproval;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isAdminApproval() {
        return adminApproval;
    }

    public void setAdminApproval(boolean adminApproval) {
        this.adminApproval = adminApproval;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ImageUrl{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", productId=" + productId +
                ", adminApproval=" + adminApproval +
                '}';
    }
}
