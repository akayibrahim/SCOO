package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.RidingCoordinates;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */

@Repository
public interface RidingCoordinatesRepository extends MongoRepository<RidingCoordinates, String> {
    Optional<RidingCoordinates> findById(String id);

    RidingCoordinates save(RidingCoordinates ridingCoordinates);

    void deleteById(String id);

    List<RidingCoordinates> findByRidingId(String ridingId);
}
