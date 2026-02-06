package com.ssunnykku.study_test.studylog.domain.entity;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class StudyLog {
    private long id;
    private String reflection;
    private boolean hasStudy;
    private LocalDateTime createdAt;

    public StudyLog(long id, String reflection, boolean hasStudy) {
        this.id = id;
        this.reflection = reflection;
        this.hasStudy = hasStudy;
    }

    public StudyLog(long id, String reflection, boolean hasStudy, LocalDateTime createdAt) {
        this.id = id;
        this.reflection = reflection;
        this.hasStudy = hasStudy;
        this.createdAt = createdAt;
    }

    public StudyLog() {
    };

}
