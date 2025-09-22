package com.schwedlermobile.basketservice.request;

import lombok.Builder;

@Builder
public record ProductRequest(Long id, Integer quantity) {
}
