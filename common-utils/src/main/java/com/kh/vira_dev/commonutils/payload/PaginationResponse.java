package com.kh.vira_dev.commonutils.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginationResponse<T> {

    private boolean success;
    private int status;
    private String description;
    private Page<T> content;
    private int number;
    private int size;
    private int page;
    private long element;
    private boolean hasNext;
    private boolean hasPrevious;
    private LocalDateTime timestamp;

    public static <T> PaginationResponse<T> success(HttpStatus status, String description, Page<T> content) {
        return builderPaginationResponse(status , description , content);
    }

    public static <T> PaginationResponse<T> builderPaginationResponse(HttpStatus status,
                                                                        String description, Page<T> content) {
            return PaginationResponse
                    .<T>builder()
                    .success(true)
                    .status(status.value())
                    .description(description)
                    .content(content)
                    .number(content.getNumber())
                    .size(content.getSize())
                    .page(content.getTotalPages())
                    .element(content.getTotalElements())
                    .hasNext(content.hasNext())
                    .hasPrevious(content.hasPrevious())
                    .timestamp(LocalDateTime.now())
                    .build();
    }

}
