package com.fred.event_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer category;
    private String summary;
    private String details;
    private Integer owner;
    private Integer venue;
    private Boolean isDeleted;
    private Integer createdBy;
    private LocalDate eventDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}