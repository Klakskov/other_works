package com.example.work.adapter.in.controllers;

import com.example.work.adapter.domain.request.GetPriceRequest;
import com.example.work.adapter.domain.response.GetProductResponse;
import com.example.work.adapter.mappers.PriceMapper;
import com.example.work.application.ports.in.PriceServicePortIn;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/prices")
public class PricesControllerV1 {

    private final PriceServicePortIn priceServicePortIn;
    private final PriceMapper priceMapper;

    @GetMapping()
    public List<GetProductResponse> getProduct(GetPriceRequest requestData) {
        return priceMapper.toResponse(
                priceServicePortIn.findByData(
                        priceMapper.toAppInput(requestData)
                )
        );
    }

}
