package com.schwedlermobile.basketservice.response;

import com.schwedlermobile.basketservice.model.ProductEntity;
import com.schwedlermobile.basketservice.model.Status;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record BasketResponse(String id, Long clientId, BigDecimal totalPrice, List<ProductEntity> products, Status status) {
}
