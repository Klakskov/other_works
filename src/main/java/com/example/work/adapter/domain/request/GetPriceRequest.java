package com.example.work.adapter.domain.request;

import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record GetPriceRequest(
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        @NotNull
        LocalDateTime date,
        @NotNull
        Long productId,
        @NotNull
        Long chainId,
        Integer limit,
        Integer offset
) {
        public GetPriceRequest {
                if (limit == null) limit = 100;
                if(offset == null) offset = 0;
                if (date == null) date = LocalDateTime.now();
        }
}
