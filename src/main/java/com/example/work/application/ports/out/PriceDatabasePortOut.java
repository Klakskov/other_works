package com.example.work.application.ports.out;

import com.example.work.application.domain.input.GetProductAppInput;
import com.example.work.application.domain.response.GetProductAppResponse;

import java.util.List;

public interface PriceDatabasePortOut {
    List<GetProductAppResponse> getProducts(GetProductAppInput appInput);
}
