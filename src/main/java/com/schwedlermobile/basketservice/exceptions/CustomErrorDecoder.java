package com.schwedlermobile.basketservice.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder  implements ErrorDecoder {
    @Override
    public Exception decode(String method, Response response) {
        switch (response.status()){
            case 400:
                return new DataNotFoundException("Product not found");
            default:
                return new Exception("Exception while getting product");
        }
    }
}
