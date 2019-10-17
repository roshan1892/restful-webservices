package com.roshanweb.restfulwebservices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * UserNotFoundException for handling exceptions if the user is not found
 *
 * @author RoshanBhandari
 * @version 1.0.0
 * @since 2 Sep 2019
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super(message);
  }
}
