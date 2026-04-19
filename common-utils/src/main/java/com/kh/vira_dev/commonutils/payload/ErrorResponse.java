package com.kh.vira_dev.commonutils.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse<T> {
    
    private boolean success;
    private int status;
    private String message;
    private T error;
    private LocalDateTime timestamp;
    
    public static <T> ErrorResponse<T> success(String message) {
        return builderErrorResponse(HttpStatus.BAD_REQUEST , message , null);
    }

    public static <T> ErrorResponse<T> success(String message, HttpStatus status) {
        return builderErrorResponse(status , message, null);
    }

    public static <T> ErrorResponse<T> success(String message, HttpStatus status, T error) {
        return builderErrorResponse(status , message, error);
    }

    private static <T> ErrorResponse<T> builderErrorResponse(HttpStatus status, String message , T error) {
        return ErrorResponse
                .<T>builder()
                .success(false)
                .status(status.value())
                .message(message)
                .error(error)
                .timestamp(LocalDateTime.now())
                .build();
    }
    
}
