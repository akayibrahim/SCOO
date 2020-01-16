package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.Alert;
import com.iakay.scoo.dao.model.RidingLog;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */

@Repository
public interface RidingLogRepository extends MongoRepository<RidingLog, String> {
    Optional<RidingLog> findById(String id);

    RidingLog save(RidingLog ridingLog);

    void deleteById(String id);
}
