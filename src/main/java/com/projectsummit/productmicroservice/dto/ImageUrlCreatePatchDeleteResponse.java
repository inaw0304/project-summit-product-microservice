package com.projectsummit.productmicroservice.dto;

import com.projectsummit.productmicroservice.entity.ImageUrl;

import java.util.Optional;

public class ImageUrlCreatePatchDeleteResponse {

    private String status;

    private Optional<ImageUrl> imageUrl;

    public ImageUrlCreatePatchDeleteResponse(String status, Optional<ImageUrl> imageUrl) {
        this.status = status;
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Optional<ImageUrl> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Optional<ImageUrl> imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ImageUrlCreatePatchDeleteResponse{" +
                "status='" + status + '\'' +
                ", imageUrl=" + imageUrl +
                '}';
    }
}
