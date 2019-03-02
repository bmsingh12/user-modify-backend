package com.springboot.rest.example.springbootrestservice.controller;

import com.springboot.rest.example.springbootrestservice.model.User;
import com.springboot.rest.example.springbootrestservice.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {
    private final UserRepository userRepository;

    @Autowired
    public userController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") ObjectId id) {
        return userRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody User user) {
        user.setId(id);
        userRepository.save(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User createUser(@Valid @RequestBody User user) {
        user.setId(ObjectId.get());
        userRepository.save(user);
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable ObjectId id) {
        userRepository.delete(userRepository.findById(id));
    }

}
