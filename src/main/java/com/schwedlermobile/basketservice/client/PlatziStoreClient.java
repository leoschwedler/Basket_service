package com.schwedlermobile.basketservice.client;

import com.schwedlermobile.basketservice.exceptions.CustomErrorDecoder;
import com.schwedlermobile.basketservice.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PlatziStoreClient", url = "${basket.client.platzi}", configuration = {CustomErrorDecoder.class})
public interface PlatziStoreClient {

    @GetMapping("/products")
    public List<ProductResponse> getAllProducts();

    @GetMapping("/products/{id}")
    public ProductResponse getProducById(@PathVariable Long id);
}
