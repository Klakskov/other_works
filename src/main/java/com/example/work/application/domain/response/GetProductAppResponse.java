package com.example.work.application.domain.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetProductAppResponse {
    private String productId;
    private String chainId;
    private BigDecimal rateToApply;
    private BigDecimal finalPriceToApply;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
}
