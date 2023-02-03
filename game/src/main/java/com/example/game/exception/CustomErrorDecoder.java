package com.example.game.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == 404) {
            return new NotFoundException("VocabService not found");
        }
        if (response.status() == 500) {
            return new ConnectionErrorException();
        }
        return new Exception(response.reason());
    }
}
