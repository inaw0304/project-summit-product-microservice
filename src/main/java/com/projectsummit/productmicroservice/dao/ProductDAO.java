package com.projectsummit.productmicroservice.dao;

import com.projectsummit.productmicroservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO
        extends JpaRepository<Product,Long> {

}
