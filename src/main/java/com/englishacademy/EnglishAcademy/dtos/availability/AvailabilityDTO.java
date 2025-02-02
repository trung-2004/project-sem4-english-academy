package com.englishacademy.EnglishAcademy.dtos.availability;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvailabilityDTO {
    private Long tutorId;
    private String tutorName;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long id;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String createdBy;
    private String modifiedBy;
}
