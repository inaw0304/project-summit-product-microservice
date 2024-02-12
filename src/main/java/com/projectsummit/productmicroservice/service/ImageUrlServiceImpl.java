package com.projectsummit.productmicroservice.service;

import com.projectsummit.productmicroservice.controller.ImageUrlNotFoundException;
import com.projectsummit.productmicroservice.dao.ImageUrlDAO;
import com.projectsummit.productmicroservice.dto.ImageUrlCreatePatchDeleteResponse;
import com.projectsummit.productmicroservice.entity.ImageUrl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageUrlServiceImpl implements ImageUrlService{

    ImageUrlDAO imageUrlDAO;

    @Autowired
    public ImageUrlServiceImpl(ImageUrlDAO imageUrlDAO){
        this.imageUrlDAO = imageUrlDAO;
    }

    @Override
    public List<ImageUrl> getAllImageUrls() {
        return this.imageUrlDAO.findAll();
    }

    @Override
    public List<ImageUrl>  getImageUrlsByProductId(Long productId){
        return imageUrlDAO.findByProductId(productId);
    }

    @Override
    @Transactional
    public ImageUrlCreatePatchDeleteResponse createNewImageUrl(ImageUrl imageUrl) {
        imageUrlDAO.save(imageUrl);

        return new ImageUrlCreatePatchDeleteResponse("success",imageUrlDAO.findById(imageUrl.getId()));
    }

    @Override
    @Transactional
    public ImageUrlCreatePatchDeleteResponse updateImageUrl(Long imageUrlId, ImageUrl imageUrl)  {

        boolean exists = imageUrlDAO.existsById(imageUrlId);

        if(!exists){
            throw new ImageUrlNotFoundException("ImageUrl not found - "+ imageUrlId);
        }

        Optional<ImageUrl> foundImageUrl = imageUrlDAO.findById(imageUrlId);

        if(foundImageUrl.isPresent()){

            if(imageUrl.getImageUrl()!=null){
                foundImageUrl.get().setImageUrl(imageUrl.getImageUrl());
            }

            foundImageUrl.get().setAdminApproval(false);

        }else{
            throw new ImageUrlNotFoundException("ImageUrl not found - "+ imageUrlId);
        }

        return new ImageUrlCreatePatchDeleteResponse("success",foundImageUrl);

    }

    @Override
    @Transactional
    public ImageUrlCreatePatchDeleteResponse deleteImageUrlByImageUrlId(Long imageUrlId) {
        boolean exists = imageUrlDAO.existsById(imageUrlId);

        if(!exists){
            throw new ImageUrlNotFoundException("ImageUrl not found - "+ imageUrlId);
        }

        Optional<ImageUrl> imageUrl = imageUrlDAO.findById(imageUrlId);

        imageUrlDAO.deleteById(imageUrlId);

        return new ImageUrlCreatePatchDeleteResponse("success",imageUrl);
    }

    @Override
    @Transactional
    public ImageUrlCreatePatchDeleteResponse deleteImageUrlByProductId(Long productId) {

        List<ImageUrl> imageUrls = imageUrlDAO.findByProductId(productId);

        if(imageUrls.isEmpty()){
            throw new ImageUrlNotFoundException("ImageUrl not found for product id " + productId);
        }

        imageUrlDAO.deleteByProductId(productId);

        return new ImageUrlCreatePatchDeleteResponse("success",null);
    }

}
