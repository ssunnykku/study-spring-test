package com.ssunnykku.study_test.studylog.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
public class StudyLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reflection;
    private Boolean hasStudied;
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
