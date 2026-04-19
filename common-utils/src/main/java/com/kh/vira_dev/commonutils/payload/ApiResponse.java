package com.kh.vira_dev.commonutils.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {

    private boolean success;
    private int status;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public static <T> ApiResponse<T> success(String message) {
        return builderApiResponse(HttpStatus.OK, message , null);
    }
    
    public static <T> ApiResponse<T> success(String message , T data) {
        return builderApiResponse(HttpStatus.OK, message , data);
    }
    
    public static <T> ApiResponse<T> success(HttpStatus status, String message , T data) {
        return builderApiResponse(status, message , data);
    }

    private static <T> ApiResponse<T> builderApiResponse(HttpStatus status, String message, T data) {
        return ApiResponse
                .<T>builder()
                .status(status.value())
                .success(true)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    } 
}
