package com.example.work.application.services;

import com.example.work.application.domain.input.GetProductAppInput;
import com.example.work.application.domain.response.GetProductAppResponse;
import com.example.work.application.ports.in.PriceServicePortIn;

public class PriceServiceImpl implements PriceServicePortIn {


    @Override
    public GetProductAppResponse findByData(GetProductAppInput appInput) {
        return null;
    }
}
