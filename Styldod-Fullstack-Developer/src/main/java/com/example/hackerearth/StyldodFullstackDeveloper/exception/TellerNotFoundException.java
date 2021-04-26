package com.example.hackerearth.StyldodFullstackDeveloper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TellerNotFoundException extends RuntimeException{
    public TellerNotFoundException(String s) {
       // System.out.println(s+"...............");
        super(s);
    }

   /* public String TellerNotFoundException(String message) {
       // super(message);
        return message;
    }*/
}
