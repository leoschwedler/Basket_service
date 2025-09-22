package com.schwedlermobile.basketservice.mapper;

import com.schwedlermobile.basketservice.model.BasketEntity;
import com.schwedlermobile.basketservice.response.BasketResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BasketMapper {

    public static BasketResponse map(BasketEntity entity){
        return BasketResponse.builder()
                .id(entity.getId())
                .clientId(entity.getClient())
                .totalPrice(entity.getTotalPrice())
                .products(entity.getProducts())
                .status(entity.getStatus())
                .build();
    }
}
