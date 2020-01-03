package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.ProblemReporting;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */
@EnableScan
@Repository
public interface ProblemReportingRepository extends CrudRepository<ProblemReporting, String> {
    Optional<ProblemReporting> findById(String id);

    ProblemReporting save(ProblemReporting problemReporting);

    void deleteById(String id);
}
