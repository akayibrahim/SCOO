package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.Alert;
import com.iakay.scoo.dao.model.Scooter;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */

@Repository
public interface ScooterRepository extends MongoRepository<Scooter, String> {
    Optional<Scooter> findById(String id);

    Optional<Scooter> findByLabel(String id);

    Scooter save(Scooter scooter);

    void deleteById(String id);
}
