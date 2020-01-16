package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.CardInformation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */

@Repository
public interface CardInformationRepository extends MongoRepository<CardInformation, String> {
    Optional<CardInformation> findById(String id);

    CardInformation save(CardInformation cardInformation);

    void deleteById(String id);
}
