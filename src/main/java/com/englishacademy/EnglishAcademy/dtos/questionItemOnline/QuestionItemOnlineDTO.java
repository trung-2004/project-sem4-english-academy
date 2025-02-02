package com.englishacademy.EnglishAcademy.dtos.questionItemOnline;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionItemOnlineDTO {
    private Long id;
    private String title;

    private String answer1;

    private String answer2;

    private String answer3;

    private String answer4;

    private String answerCorrect;

    private Integer orderTop;

    private Timestamp createdDate;

    private Timestamp modifiedDate;

    private String createdBy;

    private String modifiedBy;
}
