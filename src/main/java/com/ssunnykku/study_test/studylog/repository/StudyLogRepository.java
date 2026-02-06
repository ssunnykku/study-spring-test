package com.ssunnykku.study_test.studylog.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ssunnykku.study_test.studylog.domain.entity.StudyLog;

@Repository
public interface StudyLogRepository {
    StudyLog save(StudyLog studyLog);

    Optional<StudyLog> findByCreatedDate(LocalDateTime start, LocalDateTime end);
}
