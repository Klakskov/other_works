package com.example.work.adapter.mappers;

import com.example.work.adapter.domain.entities.PriceEntity;
import com.example.work.adapter.domain.request.GetPriceRequest;
import com.example.work.adapter.domain.response.GetProductResponse;
import com.example.work.application.domain.PriceCore;
import com.example.work.application.domain.input.GetProductAppInput;
import com.example.work.application.domain.response.GetProductAppResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring") // generates Spring bean
public interface PriceMapper {

    GetProductAppInput toAppInput(GetPriceRequest product);
    GetProductResponse toResponse(GetProductAppResponse appResponse);
    List<GetProductResponse> toResponse(List<GetProductAppResponse> appResponse);

    @Mapping(source = "priceList", target = "rate")
    GetProductResponse toGetProductAppResponse(PriceCore priceCore);
    PriceCore toPriceCoreList(PriceEntity entityList);

}
