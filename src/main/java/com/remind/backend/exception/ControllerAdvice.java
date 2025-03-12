package com.remind.backend.exception;

import com.remind.backend.model.CommonResult;
import com.remind.backend.service.ResponseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;

@RestControllerAdvice
@AllArgsConstructor
public class ControllerAdvice {

    private final ResponseService responseService;
    @ExceptionHandler(NullPointerException.class)
    public CommonResult handleCustomException(HttpServletRequest request, NullPointerException e){
        return responseService.getFailResult(1000, "this is npe!");
    }

    @ExceptionHandler(CustomExceptionForTest.class)
    public CommonResult customException(HttpServletRequest request, CustomExceptionForTest e){
        return responseService.getFailResult(1001, "this is customException!!");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public CommonResult constraintViolation(HttpServletRequest request, ConstraintViolationException e){
        return responseService.getFailResult(1002, "Invalid Parameter!");
    }

    @ExceptionHandler(BindException.class)
    public CommonResult bindException(HttpServletRequest request, BindException e){
        return responseService.getFailResult(1003, "bind exception occurred.");
    }

    @ExceptionHandler(DataAccessResourceFailureException.class)
    public CommonResult dbConnectException(HttpServletRequest request, DataAccessResourceFailureException e){
        return responseService.getFailResult(1004, "database connection failed");
    }
}
