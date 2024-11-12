package com.ivandjoh.product_service.repository;

import com.ivandjoh.product_service.model.Product;
import com.ivandjoh.product_service.model.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStatus(ProductStatus status);
}
