package com.projectsummit.productmicroservice.service;

import com.projectsummit.productmicroservice.dto.ImageUrlCreatePatchDeleteResponse;
import com.projectsummit.productmicroservice.entity.ImageUrl;

import java.util.List;

public interface ImageUrlService {

    List<ImageUrl> getAllImageUrls();

    List<ImageUrl> getImageUrlsByProductId(Long productId);

    ImageUrlCreatePatchDeleteResponse createNewImageUrl(ImageUrl imageUrl);

    ImageUrlCreatePatchDeleteResponse updateImageUrl(Long imageUrlId,ImageUrl imageUrl);


    ImageUrlCreatePatchDeleteResponse deleteImageUrlByImageUrlId(Long imageUrlId);

    ImageUrlCreatePatchDeleteResponse deleteImageUrlByProductId(Long productId);
}
