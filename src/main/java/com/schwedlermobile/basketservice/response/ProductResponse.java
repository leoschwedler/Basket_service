package com.schwedlermobile.basketservice.response;

import lombok.Builder;

import java.io.Serializable;
import java.math.BigDecimal;
@Builder
public record ProductResponse(Long id, String title, BigDecimal price) implements Serializable {
}
