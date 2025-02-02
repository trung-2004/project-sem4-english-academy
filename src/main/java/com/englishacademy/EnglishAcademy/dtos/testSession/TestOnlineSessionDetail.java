package com.englishacademy.EnglishAcademy.dtos.testSession;

import com.englishacademy.EnglishAcademy.dtos.questionTestOnline.QuestionTestOnlineDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestOnlineSessionDetail {
    private Long id;
    private Long testInputId;

    private Long sessionId;

    private String sessionName;

    private Integer totalQuestion;

    private Integer orderTop;

    private List<QuestionTestOnlineDTO> questionTestOnlineDTOS;
    private Timestamp createdDate;

    private Timestamp modifiedDate;

    private String createdBy;

    private String modifiedBy;
}
