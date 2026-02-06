package com.ssunnykku.study_test.studylog.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ssunnykku.study_test.studylog.domain.entity.StudyLog;
import com.ssunnykku.study_test.studylog.exception.StudyLogException;
import com.ssunnykku.study_test.studylog.repository.StudyLogRepository;

@ExtendWith(MockitoExtension.class)
public class StudyLogServiceTest {

    @Mock
    private StudyLogRepository studyLogRepository;

    @InjectMocks
    private StudyLogService studyLogService;

    @Test
    void 하루에_한_번_이상_체크하면_예외_발생() {
        StudyLog studyLog = new StudyLog();
        when(studyLogRepository.findByCreatedDate(any(), any())).thenReturn(Optional.of(studyLog));

        // when & then
        assertThatThrownBy(() -> studyLogService.createReplication(1L, "reflection", true))
                .isInstanceOf(StudyLogException.class)
                .hasMessage("회고는 하루에 하나씩만 입력이 가능합니다.");
    }

    @Test
    void 학습체크_회고_기록() {
        // given
        StudyLog studyLog = new StudyLog(1, "회고", true, LocalDateTime.now());
        when(studyLogRepository.findByCreatedDate(any(), any()))
                .thenReturn(Optional.empty());
        when(studyLogRepository.save(any(StudyLog.class))).thenReturn(studyLog);

        // when
        StudyLog result = studyLogService.createReplication(1L, "회고", true);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getReflection()).isEqualTo("회고");
        assertThat(result.isHasStudy()).isTrue();
    }

}
