package com.example.game.exception;

import com.example.game.exception.CustomErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    public class MyFeignClientConfiguration {

        @Bean
        public ErrorDecoder errorDecoder() {
            return new CustomErrorDecoder();
        }
    }
}
