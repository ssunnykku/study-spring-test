package com.ssunnykku.study_test.studylog.exception;

public class StudyLogException extends RuntimeException {

    private final int ERR_CODE;

    public StudyLogException(String message, int errCode) {
        super(message);
        ERR_CODE = errCode;
    }

    public StudyLogException(String message) {
        this(message, 400);
    }

    public int getErrCode() {
        return ERR_CODE;
    }

}
