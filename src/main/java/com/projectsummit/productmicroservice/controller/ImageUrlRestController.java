package com.projectsummit.productmicroservice.controller;

import com.projectsummit.productmicroservice.dto.ImageUrlCreatePatchDeleteResponse;
import com.projectsummit.productmicroservice.entity.ImageUrl;
import com.projectsummit.productmicroservice.service.ImageUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ImageUrlRestController {

    ImageUrlService imageUrlService;

    @Autowired
    ImageUrlRestController(ImageUrlService imageUrlService){
        this.imageUrlService = imageUrlService;
    }

    @GetMapping("/imageurls")
    public List<ImageUrl> getAllImageUrls(){
        return imageUrlService.getAllImageUrls();
    }

    @GetMapping("/imageurls/{productId}")
    public List<ImageUrl> getAllImageUrlsByProductId(@PathVariable("productId") Long productId){
        return imageUrlService.getImageUrlsByProductId(productId);
    }

    @PostMapping("/imageurls")
    public ImageUrlCreatePatchDeleteResponse createNewImageUrl(@RequestBody ImageUrl imageUrl){
        return imageUrlService.createNewImageUrl(imageUrl);
    }

    // can only update the imageUrl field
    @PatchMapping("/imageurls/{imageUrlId}")
    public ImageUrlCreatePatchDeleteResponse updateImageUrl(@PathVariable("imageUrlId") Long imageUrlId, @RequestBody ImageUrl imageUrl){
        return imageUrlService.updateImageUrl(imageUrlId,imageUrl);
    }

    @DeleteMapping("/imageurls/{imageUrlId}")
    public ImageUrlCreatePatchDeleteResponse deleteImageUrlByImageUrlId(@PathVariable("imageUrlId") Long imageUrlId){
        return imageUrlService.deleteImageUrlByImageUrlId(imageUrlId);
    }

    @DeleteMapping("/imageurls/productId={productId}")
    public ImageUrlCreatePatchDeleteResponse deleteImageUrlByProductId(@PathVariable("productId") Long productId){
        return imageUrlService.deleteImageUrlByProductId(productId);
    }



}
