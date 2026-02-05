package com.example.work.application.ports.in;

import com.example.work.application.domain.PriceCore;
import com.example.work.application.domain.input.GetProductAppInput;

public interface PriceServicePortIn {

    PriceCore findByData(GetProductAppInput appInput);
}
