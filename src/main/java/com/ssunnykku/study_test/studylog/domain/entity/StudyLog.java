package com.ssunnykku.study_test.studylog.domain.entity;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
public class StudyLog {
    private long id;
    private String reflection;
    private boolean hasStudied;
    private LocalDateTime createdAt;

    public static StudyLog of(String reflection, boolean hasStudied) {
        return StudyLog.builder()
                .reflection(reflection)
                .hasStudied(hasStudied)
                .build();
    }

    public static StudyLog of(String reflection, boolean hasStudied, LocalDateTime createdAt) {
        return StudyLog.builder()
                .reflection(reflection)
                .hasStudied(hasStudied)
                .createdAt(createdAt)
                .build();
    }

    public static StudyLog of() {
        return new StudyLog();
    }

}
