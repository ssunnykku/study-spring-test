package com.ssunnykku.study_test.studylog.controller.dto;

import java.time.LocalDateTime;

public record CreateLogResponse(long id, String reflection, boolean hasStudied, LocalDateTime createdAt) {

    public static CreateLogResponse of(long id, String reflection, boolean hasStudied, LocalDateTime createdAt) {
        return new CreateLogResponse(id, reflection, hasStudied, createdAt);
    }
}
