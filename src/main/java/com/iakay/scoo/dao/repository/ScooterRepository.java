package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.Alert;
import com.iakay.scoo.dao.model.Scooter;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */
@EnableScan
@Repository
public interface ScooterRepository extends CrudRepository<Scooter, String> {
    Optional<Scooter> findById(String id);

    Scooter save(Scooter scooter);

    void deleteById(String id);
}
