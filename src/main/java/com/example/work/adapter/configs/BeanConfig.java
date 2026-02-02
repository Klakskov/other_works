package com.example.work.adapter.configs;

import com.example.work.application.ports.in.PriceServicePortIn;
import com.example.work.application.ports.out.PriceDatabasePortOut;
import com.example.work.application.services.PriceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public PriceServicePortIn productService(PriceDatabasePortOut priceDatabasePortOut) {
        return new PriceServiceImpl(priceDatabasePortOut);
    }
}
