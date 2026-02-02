package com.example.work.application.ports.in;

import com.example.work.application.domain.input.GetProductAppInput;
import com.example.work.application.domain.response.GetProductAppResponse;

import java.util.List;

public interface PriceServicePortIn {

    List<GetProductAppResponse> findByData(GetProductAppInput appInput);
}
