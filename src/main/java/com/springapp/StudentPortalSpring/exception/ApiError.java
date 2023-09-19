package com.springapp.StudentPortalSpring.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiError {
    private String errorMessage;

    private String errorCode;

    private String request;

    private String requestType;

    private String customMessage;
}
