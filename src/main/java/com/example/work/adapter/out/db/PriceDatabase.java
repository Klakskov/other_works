package com.example.work.adapter.out.db;

import com.example.work.adapter.mappers.PriceMapper;
import com.example.work.application.domain.input.GetProductAppInput;
import com.example.work.application.domain.response.GetProductAppResponse;
import com.example.work.application.ports.out.PriceDatabasePortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PriceDatabase implements PriceDatabasePortOut {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    @Override
    public List<GetProductAppResponse> getProducts(GetProductAppInput appInput) {
        var priceList = priceRepository.findApplicablePrices(
                appInput.getDate(),
                appInput.getProductId(),
                appInput.getChainId()
        );

        return priceMapper.toGetProductAppResponse(priceList);
    }
}
