package com.schwedlermobile.basketservice.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
public record BasketRequest(Long clientId, List<ProductRequest> products) {
}
