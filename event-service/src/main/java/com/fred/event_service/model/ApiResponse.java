package com.fred.event_service.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private int resultCode;
    private String message;
    private Object data;
}
