package com.ssunnykku.study_test.studylog.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CreateLogRequest(@NotEmpty String reflection, @NotBlank boolean hasStudied) {

}