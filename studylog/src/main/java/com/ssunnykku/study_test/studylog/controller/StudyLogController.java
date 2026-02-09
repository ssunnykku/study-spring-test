package com.ssunnykku.study_test.studylog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssunnykku.study_test.studylog.controller.dto.CreateLogRequest;
import com.ssunnykku.study_test.studylog.controller.dto.CreateLogResponse;
import com.ssunnykku.study_test.studylog.domain.entity.StudyLog;
import com.ssunnykku.study_test.studylog.service.StudyLogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudyLogController {
    private final StudyLogService studyLogService;

    @PostMapping("/studies")
    public ResponseEntity<CreateLogResponse> postStudyLog(CreateLogRequest createLogRequest) {
        StudyLog studyLog = studyLogService.createReplication(createLogRequest.reflection(),
                createLogRequest.hasStudied());

        CreateLogResponse response = CreateLogResponse.of(studyLog.getId(), studyLog.getReflection(),
                studyLog.getHasStudied(),
                studyLog.getCreatedAt());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
