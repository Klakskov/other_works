package com.example.work.application.domain;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetProductInput {
    private OffsetDateTime date;
    private String productId;
    private String chainId;
    private int limit;
    private int offset;
}
