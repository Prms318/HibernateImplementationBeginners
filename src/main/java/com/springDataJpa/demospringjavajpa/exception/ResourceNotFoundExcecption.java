package com.springDataJpa.demospringjavajpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//When not found exception is found this class will be excited
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcecption extends  RuntimeException {
    private  String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundExcecption(String resourceName,String fieldName,Long fieldValue){
        super(String.format("%s not found with %s: %s",resourceName,fieldName,fieldValue));
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }
}
