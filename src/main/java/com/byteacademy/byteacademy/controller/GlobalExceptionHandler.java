package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.exception.EntityExistException;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.model.ExceptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDTO handleNotFound(EntityNotFoundException entityNotFoundException){
        log.error("ActionLog.error not found: {} ", entityNotFoundException.getMessage());
        return new ExceptionDTO(HttpStatus.NOT_FOUND.value(), entityNotFoundException.getMessage());
    }

    @ExceptionHandler(EntityExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionDTO handleExist(EntityExistException entityExistException){
        log.error("ActionLog.error entity exist: {} ", entityExistException.getMessage());
        return new ExceptionDTO(HttpStatus.CONFLICT.value(), entityExistException.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionDTO handleDataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException){
        log.error("ActionLog.error integrity violation: {} ", dataIntegrityViolationException.getMessage());
        return new ExceptionDTO(HttpStatus.CONFLICT.value(), dataIntegrityViolationException.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        log.error("ActionLog.error validation: {} ", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDTO handleGlobal(Exception e){
        log.error("ActionLog.error : {}", e.getMessage());
        return new ExceptionDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO handleBadCredentialsException(BadCredentialsException e){
        log.error("BadCredentialsException -> {}", e.getMessage());
        return new ExceptionDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO handleIllegalArgumentException(IllegalArgumentException e){
        log.error("IllegalArgumentException -> {}", e.getMessage());
        return new ExceptionDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }



}
