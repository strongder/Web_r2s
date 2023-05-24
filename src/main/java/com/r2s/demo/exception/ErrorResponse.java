package com.r2s.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private int statusCode;
    private ZonedDateTime timestamp;
    private String message;
}
