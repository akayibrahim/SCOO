package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.ProblemReporting;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */

@Repository
public interface ProblemReportingRepository extends MongoRepository<ProblemReporting, String> {
    Optional<ProblemReporting> findById(String id);

    ProblemReporting save(ProblemReporting problemReporting);

    void deleteById(String id);
}
