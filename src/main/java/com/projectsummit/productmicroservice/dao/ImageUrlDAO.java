package com.projectsummit.productmicroservice.dao;

import com.projectsummit.productmicroservice.entity.ImageUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageUrlDAO
        extends JpaRepository<ImageUrl,Long> {
    List<ImageUrl> findByProductId(Long productId);

    @Modifying
    @Query("DELETE FROM ImageUrl i WHERE i.productId = :productId")
    void deleteByProductId(@Param("productId") Long productId);

}
