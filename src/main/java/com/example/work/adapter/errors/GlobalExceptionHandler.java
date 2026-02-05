package com.example.work.adapter.errors;

import com.example.work.application.domain.exceptions.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.example.work.adapter.errors.ErrorsCode.*;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // ---- Handle @Valid body validation errors ----
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomExceptionResponse> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        log.error("error on request: " +  errors.toString());
        var err = CustomExceptionResponse.builder()
                .errorCode(BR001)
                .time(OffsetDateTime.now())
                .httpStatus(HttpStatus.BAD_REQUEST.value()).build();


        return ResponseEntity.badRequest().body(err);
    }

    // ---- Handle missing query params ----
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<CustomExceptionResponse> handleMissingParams(
            MissingServletRequestParameterException ex) {

        log.error("error on request: " +  ex.toString());

        var err = CustomExceptionResponse.builder()
                .errorCode(G001)
                .time(OffsetDateTime.now())
                .httpStatus(HttpStatus.BAD_REQUEST.value()).build();

        return ResponseEntity.badRequest().body(err);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomExceptionResponse> handleGeneric(Exception ex) {
        log.error("internal error: " +  ex.toString());

        var err = CustomExceptionResponse.builder()
                .errorCode(IE001)
                .time(OffsetDateTime.now())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<CustomExceptionResponse> handleBusinessException(BusinessException ex) {
        log.error("internal error: " +  ex.toString());

        var err = CustomExceptionResponse.builder()
                .errorCode(BS001)
                .time(OffsetDateTime.now())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }
}
