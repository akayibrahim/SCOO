package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.Alert;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */

@Repository
public interface AlertRepository extends MongoRepository<Alert, String> {
    Optional<Alert> findById(String id);

    Alert save(Alert user);

    void deleteById(String id);
}
