package com.roshanweb.restfulwebservices.controller;

import com.roshanweb.restfulwebservices.model.Name;
import com.roshanweb.restfulwebservices.model.PersonV1;
import com.roshanweb.restfulwebservices.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PersonVersioningRestController responsible for performing versioning on Restful web services using different approaches
 *
 * @author RoshanBhandari
 * @version 1.0.0
 * @since 2 Sep 2019
 */
@RestController
public class PersonVersioningRestController {

  @GetMapping(value = "/person/param", params = "version=1")
  public PersonV1 paramV1() {
    return new PersonV1("Roshan Bhandari");
  }

  @GetMapping(value = "/person/param", params = "version=2")
  public PersonV2 paramV2() {
    return new PersonV2(new Name("Roshan", "Bhandari"));
  }

  @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
  public PersonV2 headerV2() {
    return new PersonV2(new Name("Roshan", "Bhandari"));
  }

  @GetMapping(value = "/person/produces", produces = "application/theplaysoft.company.app-v1+json")
  public PersonV2 produceV2() {
    return new PersonV2(new Name("Roshan", "Bhandari"));
  }
}
