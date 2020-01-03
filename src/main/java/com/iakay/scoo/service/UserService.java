package com.iakay.scoo.service;

import com.iakay.scoo.dao.model.User;
import com.iakay.scoo.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by iakay on 2019-12-24.
 */
@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void test() {
        userRepository.save(new User());
    }
}
