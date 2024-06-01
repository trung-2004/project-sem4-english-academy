package com.englishacademy.EnglishAcademy.dtos.tutor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TutorDetail {
    private Long id;
    private String fullname;
    private String code;
    private String phone;
    private Integer level;
    private String avatar;
    private String address;
    private String cetificate;
    private String experience;
    private String teachingSubject;
    private Double hourlyRate;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String createdBy;
    private String modifiedBy;
}
