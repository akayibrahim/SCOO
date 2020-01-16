package com.iakay.scoo.controller;

import com.iakay.scoo.dao.model.User;
import com.iakay.scoo.dao.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by iakay on 2020-01-11.
 */
@Api(tags = "User Controller")
@RestController(value = "/user")
@RequestMapping(method = RequestMethod.POST)
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "Adding User To Scoo.")
    @RequestMapping(value = "/addUser")
    public User addUser(User user) {
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }

    @ApiOperation(value = "Is user exist.")
    @RequestMapping(value = "/canLogin")
    public boolean canLogin(String email, String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        return user.isPresent();
    }

    @ApiOperation(value = "Get users.")
    @RequestMapping(value = "/findAll")
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
