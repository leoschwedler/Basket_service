package com.schwedlermobile.basketservice.controller;

import com.schwedlermobile.basketservice.dto.ProductResponseDTO;
import com.schwedlermobile.basketservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> response = service.getAllProducts();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ProductResponseDTO> getProducById(@PathVariable Long id){
        ProductResponseDTO response = service.getProducById(id);
        return ResponseEntity.ok(response);
    }
}
