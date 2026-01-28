package com.example.work.adapter.domain.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

public record GetPriceRequest(
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        OffsetDateTime date,
        String productId,
        String chainId,
        int limit,
        int offset
) {
        public GetPriceRequest {
                if (limit == 0) limit = 100;
                if (date == null) date = OffsetDateTime.now();
        }
}
