package com.example.work.adapter.domain.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record GetPriceRequest(
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        @NotNull
        LocalDateTime date,
        @NotNull
        @PositiveOrZero
        Long productId,
        @NotNull
        @PositiveOrZero
        Long chainId
) {
}
