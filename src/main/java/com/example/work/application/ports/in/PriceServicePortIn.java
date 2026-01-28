package com.example.work.application.ports.in;

import com.example.work.application.domain.input.GetProductAppInput;
import com.example.work.application.domain.response.GetProductAppResponse;

public interface PriceServicePortIn {

    GetProductAppResponse findByData(GetProductAppInput appInput);
}
