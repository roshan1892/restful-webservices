package com.roshanweb.restfulwebservices.service;

import com.roshanweb.restfulwebservices.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@Component
public class UserService {
  private static List<User> users = new ArrayList<>();
  private static int userCount = 3;

  static {
    users.add(new User(1, "Roshan", new Date()));
    users.add(new User(2, "Rabin", new Date()));
    users.add(new User(3, "Sachin", new Date()));
  }

  public List<User> findAll() {
    return users;
  }

  public User saveUser(User user) {

    user.setId(++userCount);
    users.add(user);
    return user;
  }

  public User findUserById(Long id) {
    for (User user : users) {
      if (user.getId() == id) {
        return user;
      }
    }
    return null;
  }

  public void deleteUserById(Long id) {
    Iterator<User> iterator = users.iterator();
    while (iterator.hasNext()){
      User user = iterator.next();
      if(user.getId()==id){
        iterator.remove();
      }
    }
  }
}
