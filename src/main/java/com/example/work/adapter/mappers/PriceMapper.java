package com.example.work.adapter.mappers;

import com.example.work.adapter.domain.request.GetPriceRequest;
import com.example.work.adapter.domain.response.GetProductResponse;
import com.example.work.application.domain.input.GetProductAppInput;
import com.example.work.application.domain.response.GetProductAppResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // generates Spring bean
public interface ProductMapper {

    GetProductAppInput toAppInput(GetPriceRequest product);
    GetProductResponse toResponse(GetProductAppResponse appResponse);
}
