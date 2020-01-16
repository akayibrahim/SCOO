package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.Feedback;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback, String> {
    Optional<Feedback> findById(String id);

    Feedback save(Feedback feedback);

    void deleteById(String id);
}
