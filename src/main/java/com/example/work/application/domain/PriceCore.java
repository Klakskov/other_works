package com.example.work.application.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceCore {
    private Long id;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    private Long priority;
    private BigDecimal price;
    private String currency;
    private LocalDateTime lastUpdate;
    private String lastUpdateBy;


}
