package com.fred.event_service.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Product name cannot be blank")
    private String name;
    @NotBlank(message = "Event summary cannot be blank")
    private String summary;
    private String details;
    @NotNull(message = "Product category cannot be null")
    @Min(value = 1, message = "Provide a valid category")
    private Integer category;
    private Integer owner;
    private Integer venue;
    private Integer createdBy;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private MultipartFile image;
}
