package com.ivandjoh.product_service.controller;

import com.ivandjoh.product_service.dtos.ProductRequestDTO;
import com.ivandjoh.product_service.dtos.ProductResponseDTO;
import com.ivandjoh.product_service.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<Map<String, Object>> getAllProducts() {
        List<ProductResponseDTO> products = productService.getAllApprovedProducts();
        return createResponse("success", "Products fetched successfully", products);
    }

    @PostMapping("/products")
    public ResponseEntity<Map<String, Object>> createProduct(@Valid @RequestBody ProductRequestDTO requestDTO) {
        ProductResponseDTO product = productService.createProduct(requestDTO);
        return createResponse("success", "Product created successfully", product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Map<String, Object>> getProductById(@PathVariable Long id) {
        ProductResponseDTO product = productService.getProductById(id);
        return createResponse("success", "Product fetched successfully", product);
    }


    @PutMapping("/products/{id}")
    public ResponseEntity<Map<String, Object>> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO requestDTO) {
        ProductResponseDTO product = productService.updateProduct(id, requestDTO);
        return createResponse("success", "Product updated successfully", product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return createResponse("success", "Product deleted successfully", null);
    }

    @GetMapping("/products/pending")
    public ResponseEntity<Map<String, Object>> getPendingProducts() {
        List<ProductResponseDTO> pendingProducts = productService.getPendingProducts();
        return createResponse("success", "Pending products fetched successfully", pendingProducts);
    }

    @PutMapping("/products/{id}/approve")
    public ResponseEntity<Map<String, Object>> approveProduct(@PathVariable Long id) {
        ProductResponseDTO product = productService.approveProduct(id);
        return createResponse("success", "Product approved successfully", product);
    }

    @PutMapping("/products/{id}/reject")
    public ResponseEntity<Map<String, Object>> rejectProduct(@PathVariable Long id) {
        productService.rejectProduct(id);
        return createResponse("success", "Product rejected successfully", null);
    }

    private ResponseEntity<Map<String, Object>> createResponse(String status, String message, Object data) {
        Map<String, Object> response = new LinkedHashMap<>(); // Use LinkedHashMap to maintain order
        response.put("status", status);
        response.put("message", message);
        response.put("data", data);
        return ResponseEntity.ok(response);
    }

}
