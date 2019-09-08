package com.vishwas.springbootexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ResponseStatus(HttpStatus.NOT_FOUND)
// This could be the one way of handling exceptions in the rest api world for single controller.
// But we should focus on global exception handling of all application controllers.
// using @ControllerAdvice and ResponseEntityExceptionHandler
public class TopicNotFoundException extends RuntimeException{

    private static Date timeStamp = new Date();
    private static String message = "Given topic id doesn't exists";
    private static String error= "Topic not found";

    public TopicNotFoundException(Date timeStamp, String message, String error) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.error = error;
    }

    public TopicNotFoundException() {
        super(message);
        System.out.println(this.message + this.error + this.timeStamp);
    }

    public static Date getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public static String getError() {
        return error;
    }
}
