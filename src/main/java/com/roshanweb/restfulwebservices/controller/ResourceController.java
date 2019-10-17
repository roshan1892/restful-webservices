package com.roshanweb.restfulwebservices.controller;

import com.roshanweb.restfulwebservices.model.User;
import com.roshanweb.restfulwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ResourceController responsible for performing various operations on "User" model class
 *
 * @author RoshanBhandari
 * @version 1.0.0
 * @since 2 Sep 2019
 */
@RestController
public class ResourceController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "/users")
  public List<User> getAllUsers() {
    return userService.findAll();
  }

  /**
   * method making use of HATEOAS
   *
   * @param id
   * @author RoshanBhandari
   * @version 1.0.0
   * @since 2 Sep 2019
   */
  @GetMapping(value = "/user/{id}")
  public Resource<User> getSpecificUser(@PathVariable("id") Long id) {
    User user = userService.findUserById(id);
    if (user == null) {
      throw new UserNotFoundException("id - " + id);
    }
    Resource<User> resource = new Resource<>(user);

    //link to all users
    ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());
    resource.add(linkTo.withRel("all-users"));
    return resource;
  }

  @PostMapping(value = "/users")
  private void saveUser(@RequestBody User user) {
    userService.saveUser(user);
  }

  @DeleteMapping(value = "/user/{id}")
  public void deleteUserById(@PathVariable("id") Long id) {
    userService.deleteUserById(id);
  }

}
