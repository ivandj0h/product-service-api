package com.ivandjoh.product_service.service;

import com.ivandjoh.product_service.dtos.ProductRequestDTO;
import com.ivandjoh.product_service.dtos.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getAllApprovedProducts();

    ProductResponseDTO getProductById(Long id);

    ProductResponseDTO createProduct(ProductRequestDTO requestDTO);

    ProductResponseDTO updateProduct(Long id, ProductRequestDTO requestDTO);

    void deleteProduct(Long id);

    List<ProductResponseDTO> getPendingProducts();

    ProductResponseDTO approveProduct(Long id);

    void rejectProduct(Long id);
}
