package com.schwedlermobile.basketservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tb_basket")
public class BasketEntity {

    @Id
    private String id;

    private Long client;

    private BigDecimal totalPrice;

    private List<ProductEntity> products;

    private Status status;

    private PaymentMethod payment;

    // Método para calcular o preço total do basket
    public void calculateTotalPrice() {
        this.totalPrice = products.stream()
                .map(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
