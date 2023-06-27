package com.rutatalk.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    DUPLICATED_USER_NAME(HttpStatus.CONFLICT, "UserName이 중복됩니다."),
    USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND,"Not founded"),
    TASK_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 task가 없습니다."),
    COURSE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 기수가 없습니다."),
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 글이 없습니다."),
    COMMENTS_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 댓글이 없습니다."),
    REPOSITORY_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 리포지토리가 없습니다."),
    NOTIFICATION_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 알림이 없습니다."),
    USER_COURSE_NOT_FOUND(HttpStatus.NOT_FOUND, "User가 속한 기수가 없습니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "패스워드가 잘못되었습니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "잘못된 토큰입니다."),
    EXPIRE_TOKEN(HttpStatus.UNAUTHORIZED, "토큰이 만료되었습니다."),
    INVALID_PERMISSION(HttpStatus.UNAUTHORIZED, "사용자가 권한이 없습니다."),
    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "DB에러"),
    DUPLICATED_EMAIL(HttpStatus.CONFLICT, "Email이 중복됩니다."),
    EMAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "가입된 Email이 아닙니다."),
    DUPLICATED_PREV_PASSWORD(HttpStatus.CONFLICT, "이전 비밀번호와 같게 변경할 수 없습니다."),
    FILE_UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "파일 저장에 실패했습니다."),
    ;

    private HttpStatus status;
    private String message;
}
