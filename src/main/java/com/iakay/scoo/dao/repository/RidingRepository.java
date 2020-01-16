package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.Alert;
import com.iakay.scoo.dao.model.Riding;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */

@Repository
public interface RidingRepository extends MongoRepository<Riding, String> {
    Optional<Riding> findById(String id);

    List<Riding> findByUserId(String userId);

    Riding save(Riding riding);

    void deleteById(String id);
}
