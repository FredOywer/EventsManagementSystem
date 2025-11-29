package com.fred.event_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private String name;
    private Integer category;
    private Integer owner;
    private Integer createdBy;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private MultipartFile image;
}
