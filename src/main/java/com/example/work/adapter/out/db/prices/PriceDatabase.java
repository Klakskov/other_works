package com.example.work.adapter.out.db.prices;

import com.example.work.adapter.mappers.PriceMapper;
import com.example.work.application.domain.PriceCore;
import com.example.work.application.domain.input.GetProductAppInput;
import com.example.work.application.ports.out.PriceDatabasePortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PriceDatabase implements PriceDatabasePortOut {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    @Override
    public PriceCore getProducts(GetProductAppInput appInput) {
        var priceList = priceRepository.findApplicablePrices(
                appInput.getDate(),
                appInput.getProductId(),
                appInput.getChainId()
        );

        return priceMapper.toPriceCoreList(priceList);
    }
}
