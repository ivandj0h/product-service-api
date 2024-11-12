package com.ivandjoh.product_service.mapper;

import com.ivandjoh.product_service.dtos.ProductResponseDTO;
import com.ivandjoh.product_service.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponseDTO toResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setStatus(product.getStatus().toString());
        return dto;
    }
}
