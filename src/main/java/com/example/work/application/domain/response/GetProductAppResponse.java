package com.example.work.application.domain.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetProductAppResponse {
    private long productId;
    private long chainId;
    private BigDecimal rate;
    private BigDecimal price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
