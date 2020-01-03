package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */
@EnableScan
@Repository
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findById(String id);

    User save(User user);

    void deleteById(String id);
}
