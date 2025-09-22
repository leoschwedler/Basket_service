package com.schwedlermobile.basketservice.service;

import com.schwedlermobile.basketservice.client.PlatziStoreClient;
import com.schwedlermobile.basketservice.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final PlatziStoreClient client;

    @Cacheable(value = "product")
    public List<ProductResponse> getAllProducts(){
        return client.getAllProducts();
    }
    @Cacheable(value = "product", key = "#id")
    public ProductResponse getProducById(Long id){
        return client.getProducById(id);
    }
}
