package com.remind.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomExceptionForTest extends RuntimeException{
    public CustomExceptionForTest(){
        super();
    }
    public CustomExceptionForTest(String message){
        super(message);
    }
    public CustomExceptionForTest(String message, Throwable cause){
        super(message, cause);
    }
    public CustomExceptionForTest(Throwable cause){
        super(cause);
    }
}
