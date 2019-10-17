package com.roshanweb.restfulwebservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldRestController responsible for performing internationalization on Restful web services
 *
 * @author RoshanBhandari
 * @version 1.0.0
 * @since 2 Sep 2019
 */
@RestController
public class HelloWorldRestController {

  @Autowired
  private MessageSource messageSource;

  @GetMapping(path = "/hello-world-internationalized")
  public String helloWorld() {
    return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
  }
}
