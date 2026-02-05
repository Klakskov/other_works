package com.example.work.adapter.errors;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptionResponse {
    private ErrorsCode errorCode;
    private OffsetDateTime time;
    private int httpStatus;
}
