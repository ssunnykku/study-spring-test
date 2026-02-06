package com.ssunnykku.study_test.studylog.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.ssunnykku.study_test.studylog.domain.entity.StudyLog;
import com.ssunnykku.study_test.studylog.exception.StudyLogException;
import com.ssunnykku.study_test.studylog.repository.StudyLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudyLogService {
    private final StudyLogRepository studyLogRepository;

    public StudyLog createReplication(long id, String reflection, boolean hasStudy) {
        LocalDate date = LocalDate.now();

        SearchParam dateTime = dateForSelect(date);
        studyLogRepository.findByCreatedDate(dateTime.getStart(), dateTime.getEnd()).ifPresent(log -> {
            throw new StudyLogException("회고는 하루에 하나씩만 입력이 가능합니다.");
        });

        StudyLog studyLog = studyLogRepository.save(new StudyLog(id, reflection, hasStudy));

        return studyLog;
    }

    private static SearchParam dateForSelect(LocalDate date) {

        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(LocalTime.MAX);

        SearchParam param = new SearchParam(start, end);

        return param;
    }

    private static class SearchParam {
        LocalDateTime start;
        LocalDateTime end;

        public SearchParam(LocalDateTime start, LocalDateTime end) {
            this.start = start;
            this.end = end;
        }

        public LocalDateTime getStart() {
            return start;
        }

        public LocalDateTime getEnd() {
            return end;
        }

    }

}
