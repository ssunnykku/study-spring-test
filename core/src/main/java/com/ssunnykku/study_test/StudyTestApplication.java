package com.ssunnykku.study_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan("com.ssunnykku.study_test.studylog.domain.entity")
public class StudyTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyTestApplication.class, args);
	}

}
