package com.schwedlermobile.basketservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    private Long id;

    private String title;

    private BigDecimal price;

    private Integer quantity;
}
