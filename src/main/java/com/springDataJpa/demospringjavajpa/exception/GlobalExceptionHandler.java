package com.springDataJpa.demospringjavajpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice //To handel the exception Globally
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundExcecption.class)
    public ResponseEntity<ErrorDetails> handelResourceNotFoundException(ResourceNotFoundExcecption excecption, WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                excecption.getMessage(),
                webRequest.getDescription(false),"USER_NOT_FOUND"
        );
        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SameSKUAlredyExists.class)
    public ResponseEntity<ErrorDetails> handelSkuAlreadyExistsException(SameSKUAlredyExists excecption, WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                excecption.getMessage(),
                webRequest.getDescription(false),"SKU_ALREADY_EXISTS"
        );
        return  new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> allException(Exception excecption, WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                excecption.getMessage(),
                webRequest.getDescription(false),"INTERNAL_SERVER_ERROR"
        );
        return  new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
