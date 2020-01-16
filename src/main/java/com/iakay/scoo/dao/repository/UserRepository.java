package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findById(String id);

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);

    User save(User user);

    void deleteById(String id);
}
