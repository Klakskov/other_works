package com.example.work.adapter.domain.response;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record GetProductResponse(
        String productId,
        String chainId,
        BigDecimal rateToApply,
        BigDecimal finalPriceToApply,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        OffsetDateTime startDate,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        OffsetDateTime endDate
) {
}
