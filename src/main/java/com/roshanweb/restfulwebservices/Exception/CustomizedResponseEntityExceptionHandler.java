package com.roshanweb.restfulwebservices.Exception;

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
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({Exception.class})
  public ResponseEntity<ExceptionResponse> handleError(Exception exception, WebRequest request) {
    return new ResponseEntity<>(new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false)), HttpStatus.BAD_REQUEST);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    return new ResponseEntity<>(new ExceptionResponse(new Date(), "Validation Failed", ex.getBindingResult().toString()), HttpStatus.BAD_REQUEST);
  }


}
