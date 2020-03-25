package com.iakay.scoo.controller;

import com.iakay.scoo.dao.model.Feedback;
import com.iakay.scoo.dao.model.User;
import com.iakay.scoo.dao.model.UserLog;
import com.iakay.scoo.dao.repository.FeedbackRepository;
import com.iakay.scoo.dao.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by iakay on 2020-01-11.
 */
@Api(tags = "User Controller")
@RestController
@RequestMapping(value = "/user", method = RequestMethod.POST)
@Transactional
@Validated
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;

    @ApiOperation(value = "Adding User To Scoo.")
    @RequestMapping(value = "/register")
    public User register(@Valid @RequestBody User user) {
        User existUser = userRepository.findByEmail(user.getEmail()).orElse(null);
        if(existUser != null) {
            existUser.setLastName(user.getLastName());
            existUser.setFirstName(user.getFirstName());
            existUser.setEmail(user.getEmail());
            return userRepository.save(existUser);
        } else {
            user.setCreateTime(LocalDateTime.now());
            return userRepository.save(user);
        }
    }

    @ApiOperation(value = "Is user exist.")
    @RequestMapping(value = "/canLogin")
    @Valid
    public boolean canLogin(@RequestParam @NotEmpty String email, @RequestParam @NotEmpty String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        return user.isPresent();
    }

    @ApiOperation(value = "Get users.")
    @RequestMapping(value = "/findAll")
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @ApiOperation(value = "Deleter users.")
    @RequestMapping(value = "/deleteAll")
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @ApiOperation(value = "Get feedback.")
    @RequestMapping(value = "/feedback")
    public void feedback(@RequestBody @Valid Feedback feedback) {
        feedback.setCreateTime(LocalDateTime.now());
        feedbackRepository.save(feedback);
    }
}
