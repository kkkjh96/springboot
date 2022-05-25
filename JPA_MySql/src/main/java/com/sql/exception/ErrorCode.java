package com.sql.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	/*
     * 400 BAD_REQUEST: �߸��� ��û
     */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "�߸��� ��û�Դϴ�."),

    /*
     * 404 NOT_FOUND: ���ҽ��� ã�� �� ����
     */
    POSTS_NOT_FOUND(HttpStatus.NOT_FOUND, "�Խñ� ������ ã�� �� �����ϴ�."),

    /*
     * 405 METHOD_NOT_ALLOWED: ������ ���� Request Method ȣ��
     */
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "������ ���� �޼����Դϴ�."),

    /*
     * 500 INTERNAL_SERVER_ERROR: ���� ���� ����
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "���� ���� �����Դϴ�."),

    ;

    private final HttpStatus status;
    private final String message;

}