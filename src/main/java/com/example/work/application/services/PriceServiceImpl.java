package com.example.work.application.services;

import com.example.work.application.domain.input.GetProductAppInput;
import com.example.work.application.domain.response.GetProductAppResponse;
import com.example.work.application.ports.in.PriceServicePortIn;
import com.example.work.application.ports.out.PriceDatabasePortOut;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@AllArgsConstructor
@Log4j2
public class PriceServiceImpl implements PriceServicePortIn {

    private final PriceDatabasePortOut priceDatabase;

    @Override
    public List<GetProductAppResponse> findByData(GetProductAppInput appInput) {
        return priceDatabase.getProducts(appInput);
    }
}
