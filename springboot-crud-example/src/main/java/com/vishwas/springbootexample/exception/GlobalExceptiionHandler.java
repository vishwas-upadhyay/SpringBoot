package com.vishwas.springbootexample.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController

/*GlobalExceptinHandler required when you want to throw customized exception object.
It's a good practice to have your organization specific exceptions so that you clints get more info about their request problem.
 */
public class GlobalExceptiionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(Exception.class)
    public ResponseEntity <Object> handleAllException (Exception ex, WebRequest request){
   ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(true) );
        ResponseEntity responseEntity = new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
       return responseEntity;
    }

    @ExceptionHandler(TopicNotFoundException.class)
    public ResponseEntity <Object> handleTopicNotFoundException (TopicNotFoundException  ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(true) );
        ResponseEntity responseEntity = new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
        return responseEntity;
    }


    @Override
    // We have override this method as it's not providing sufficient info to client
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),ex.getBindingResult().toString() );
        ResponseEntity responseEntity = new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}
