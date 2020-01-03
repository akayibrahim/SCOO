package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.Alert;
import com.iakay.scoo.dao.model.RidingLog;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */
@EnableScan
@Repository
public interface RidingLogRepository extends CrudRepository<RidingLog, String> {
    Optional<RidingLog> findById(String id);

    RidingLog save(RidingLog ridingLog);

    void deleteById(String id);
}
