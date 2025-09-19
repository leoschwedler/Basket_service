package com.schwedlermobile.basketservice.dto;

import lombok.Builder;

import java.io.Serializable;
import java.math.BigDecimal;
@Builder
public record ProductResponseDTO (Long id, String title, BigDecimal price) implements Serializable {
}
