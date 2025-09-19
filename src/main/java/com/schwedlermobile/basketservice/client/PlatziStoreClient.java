package com.schwedlermobile.basketservice.client;

import com.schwedlermobile.basketservice.dto.ProductResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PlatziStoreClient", url = "${basket.client.platzi}")
public interface PlatziStoreClient {

    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts();

    @GetMapping("/products/{id}")
    public ProductResponseDTO getProducById(@PathVariable Long id);
}
