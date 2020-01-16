package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.Alert;
import com.iakay.scoo.dao.model.UserLog;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */

@Repository
public interface UserLogRepository extends MongoRepository<UserLog, String> {
    Optional<UserLog> findById(String id);

    UserLog save(UserLog userLog);

    void deleteById(String id);
}
