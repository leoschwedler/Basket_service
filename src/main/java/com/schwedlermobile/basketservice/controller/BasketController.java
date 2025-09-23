package com.schwedlermobile.basketservice.controller;

import com.schwedlermobile.basketservice.mapper.BasketMapper;
import com.schwedlermobile.basketservice.model.BasketEntity;
import com.schwedlermobile.basketservice.model.ProductEntity;
import com.schwedlermobile.basketservice.model.Status;
import com.schwedlermobile.basketservice.repository.BasketRepository;
import com.schwedlermobile.basketservice.request.BasketRequest;
import com.schwedlermobile.basketservice.request.PaymentRequest;
import com.schwedlermobile.basketservice.response.BasketResponse;
import com.schwedlermobile.basketservice.response.ProductResponse;
import com.schwedlermobile.basketservice.service.BasketService;
import com.schwedlermobile.basketservice.service.ProductService;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService service;

    @PostMapping("/create")
    public ResponseEntity<BasketResponse> createBasket( @RequestBody BasketRequest request){
        BasketResponse response = service.createBasket(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<BasketResponse> getBasketById(@PathVariable String id){
        BasketResponse basket = service.getBasketById(id);
        return ResponseEntity.ok(basket);
    }

    @PutMapping("/update/{basketId}")
    public ResponseEntity<BasketResponse> updateBasket(@PathVariable String basketId, @RequestBody BasketRequest request){
        BasketResponse response = service.updateBasket(basketId,request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/payment/{basketId}")
    public ResponseEntity<BasketResponse> payBasket(@PathVariable String basketId,@RequestBody PaymentRequest request){
        BasketResponse response = service.payBasket(basketId,request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
