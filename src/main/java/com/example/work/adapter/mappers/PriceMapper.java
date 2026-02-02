package com.example.work.adapter.mappers;

import com.example.work.adapter.domain.request.GetPriceRequest;
import com.example.work.adapter.domain.response.GetProductResponse;
import com.example.work.adapter.out.db.PriceEntity;
import com.example.work.application.domain.input.GetProductAppInput;
import com.example.work.application.domain.response.GetProductAppResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring") // generates Spring bean
public interface PriceMapper {

    GetProductAppInput toAppInput(GetPriceRequest product);
    GetProductResponse toResponse(GetProductAppResponse appResponse);
    List<GetProductResponse> toResponse(List<GetProductAppResponse> appResponse);

    List<GetProductAppResponse> toGetProductAppResponse(List<PriceEntity> priceList);
}
