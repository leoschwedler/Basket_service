package com.schwedlermobile.basketservice.service;

import com.schwedlermobile.basketservice.exceptions.BusinessException;
import com.schwedlermobile.basketservice.exceptions.DataNotFoundException;
import com.schwedlermobile.basketservice.mapper.BasketMapper;
import com.schwedlermobile.basketservice.model.BasketEntity;
import com.schwedlermobile.basketservice.model.ProductEntity;
import com.schwedlermobile.basketservice.model.Status;
import com.schwedlermobile.basketservice.repository.BasketRepository;
import com.schwedlermobile.basketservice.request.BasketRequest;
import com.schwedlermobile.basketservice.request.PaymentRequest;
import com.schwedlermobile.basketservice.response.BasketResponse;
import com.schwedlermobile.basketservice.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository repository;
    private final ProductService service;

    public BasketResponse createBasket(BasketRequest request){

        repository.findByClientAndStatus(request.clientId(), Status.OPEN).ifPresent(
                basket -> {
                    throw new BusinessException("There is already an open basket for this client");
                }
        );

        List<ProductEntity> products = getProductEntities(request);
        BasketEntity basket = BasketEntity.builder()
                .client(request.clientId())
                .products(products)
                .status(Status.OPEN)
                .build();
        basket.calculateTotalPrice();
        basket = repository.save(basket);
        return BasketMapper.map(basket);
    }

    public BasketResponse getBasketById(String id){
        Optional<BasketEntity> basket = repository.findById(id);
        return basket.map(BasketMapper::map).orElseThrow(() -> new DataNotFoundException("Basket Not found"));
    }

    public BasketResponse updateBasket(String basketId, BasketRequest request){
        BasketResponse basket = getBasketById(basketId);
        List<ProductEntity> products = getProductEntities(request);
        BasketEntity basketEntity = BasketMapper.map(basket);
        basketEntity.setProducts(products);
        basketEntity.calculateTotalPrice();
        basketEntity = repository.save(basketEntity);
        return BasketMapper.map(basketEntity);
    }

    public BasketResponse payBasket(String basketId, PaymentRequest request){
        BasketResponse response = getBasketById(basketId);
        BasketEntity basket = BasketMapper.map(response);
        basket.setPayment(request.paymentMethod());
        basket.setStatus(Status.CLOSE);
        basket = repository.save(basket);
        return BasketMapper.map(basket);
    }

    public void deleteBasket(String basketId){
        BasketResponse response = getBasketById(basketId);
        BasketEntity basket = BasketMapper.map(response);
        repository.delete(basket);
    }

    private List<ProductEntity> getProductEntities(BasketRequest request) {
        List<ProductEntity> products = new ArrayList<>();
        request.products().stream().forEach(
                product -> {
                    ProductResponse response = service.getProducById(product.id());

                    products.add(ProductEntity.builder()
                            .id(response.id())
                            .title(response.title())
                            .price(response.price())
                            .quantity(product.quantity())
                            .build());});
        return products;
    }
}
