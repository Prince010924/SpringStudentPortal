package com.springapp.StudentPortalSpring.exception;

import com.springapp.StudentPortalSpring.exception.authentication.ForbiddenException;
import com.springapp.StudentPortalSpring.exception.authentication.InvalidCredentialsException;
import com.springapp.StudentPortalSpring.exception.common.BadRequestException;
import com.springapp.StudentPortalSpring.exception.common.ResourceExistsException;
import com.springapp.StudentPortalSpring.exception.common.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class ApiErrorHandler {

    @ExceptionHandler({ForbiddenException.class})
    public ResponseEntity<ApiError> handleForbiddenException(ForbiddenException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiError.builder()
                .errorMessage(e.getLocalizedMessage())
                .errorCode(HttpStatus.FORBIDDEN.toString())
                .request(request.getRequestURI())
                .requestType(request.getMethod())
                .customMessage("Forbidden")
                .build(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({InvalidCredentialsException.class})
    public ResponseEntity<ApiError> handleInvalidCredentialsException(InvalidCredentialsException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiError.builder()
                .errorMessage(e.getLocalizedMessage())
                .errorCode(HttpStatus.UNAUTHORIZED.toString())
                .request(request.getRequestURI())
                .requestType(request.getMethod())
                .customMessage("Invalid Credentials")
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<ApiError> handleAuthenticationException(AuthenticationException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiError.builder()
                .errorMessage(e.getLocalizedMessage())
                .errorCode(HttpStatus.UNAUTHORIZED.toString())
                .request(request.getRequestURI())
                .requestType(request.getMethod())
                .customMessage("Authentication Error")
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ApiError> handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiError.builder()
                .errorMessage(e.getLocalizedMessage())
                .errorCode(HttpStatus.FORBIDDEN.toString())
                .request(request.getRequestURI())
                .requestType(request.getMethod())
                .customMessage("Access is denied. You do not have the permissions to access this resource.")
                .build(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ApiError> handleBadRequestException(BadRequestException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiError.builder()
                .errorMessage(e.getLocalizedMessage())
                .errorCode(HttpStatus.BAD_REQUEST.toString())
                .request(request.getRequestURI())
                .requestType(request.getMethod())
                .customMessage("Bad Request")
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ResourceExistsException.class})
    public ResponseEntity<ApiError> handleResourceExistsException(ResourceExistsException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiError.builder().errorMessage(e.getLocalizedMessage())
                .errorCode(HttpStatus.CONFLICT.toString())
                .request(request.getRequestURI())
                .requestType(request.getMethod())
                .customMessage("Resource Already Exists")
                .build(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ApiError> handleResourceException(ResourceNotFoundException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiError.builder()
                .errorMessage(e.getLocalizedMessage())
                .errorCode(HttpStatus.NOT_FOUND.toString())
                .request(request.getRequestURI())
                .requestType(request.getMethod())
                .customMessage("Resource Not Found")
                .build(), HttpStatus.NOT_FOUND);
    }

}
