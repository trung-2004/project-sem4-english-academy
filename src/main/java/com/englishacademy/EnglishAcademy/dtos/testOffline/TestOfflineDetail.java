package com.englishacademy.EnglishAcademy.dtos.testOffline;

import com.englishacademy.EnglishAcademy.dtos.testSession.TestOfflineSessionDetail;
import com.englishacademy.EnglishAcademy.dtos.testSession.TestOnlineSessionDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestOfflineDetail {
    private Long id;
    private String title;
    private String slug;
    private Date startDate;
    private Date endtDate;
    private Integer totalQuestion;
    private Integer pastMark;
    private Integer totalMark;
    private Integer retakeTestId;
    private List<TestOfflineSessionDetail> testOfflineSessionDetails;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String createdBy;
    private String modifiedBy;
}
