package com.schwedlermobile.basketservice.request;

import com.schwedlermobile.basketservice.model.PaymentMethod;


public record PaymentRequest(
        PaymentMethod paymentMethod
) {
}
