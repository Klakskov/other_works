package com.example.work.application.ports.out;

import com.example.work.application.domain.PriceCore;
import com.example.work.application.domain.input.GetProductAppInput;

public interface PriceDatabasePortOut {
    PriceCore getProducts(GetProductAppInput appInput);
}
