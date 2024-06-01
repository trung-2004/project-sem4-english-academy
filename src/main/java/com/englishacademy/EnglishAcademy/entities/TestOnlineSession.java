package com.englishacademy.EnglishAcademy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "testOnlineSession")
public class TestOnlineSession extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testOnlineId")
    private TestOnline testOnline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sessionId")
    private Session session;

    @Column(name = "totalQuestion", nullable = false)
    private Integer totalQuestion;

    @Column(name = "orderTop", nullable = false)
    private Integer orderTop;

    @OneToMany(mappedBy = "testOnlineSession")
    @JsonIgnore
    private List<QuestionTestOnline> questionTestOnlines;
}
