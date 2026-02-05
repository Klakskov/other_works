package com.example.work.application.domain.input;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetProductAppInput {
    private LocalDateTime date;
    private long productId;
    private long chainId;
}
