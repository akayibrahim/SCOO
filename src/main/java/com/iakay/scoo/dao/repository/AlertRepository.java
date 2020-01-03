package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.Alert;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */
@EnableScan
@Repository
public interface AlertRepository extends CrudRepository<Alert, String> {
    Optional<Alert> findById(String id);

    Alert save(Alert user);

    void deleteById(String id);
}
