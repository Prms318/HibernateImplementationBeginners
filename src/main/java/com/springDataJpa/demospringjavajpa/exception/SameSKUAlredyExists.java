package com.springDataJpa.demospringjavajpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SameSKUAlredyExists extends RuntimeException{
    private String message;
  public   SameSKUAlredyExists(String message){
      super(message);
  }
}
