package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.CardInformation;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */
@EnableScan
@Repository
public interface CardInformationRepository extends CrudRepository<CardInformation, String> {
    Optional<CardInformation> findById(String id);

    CardInformation save(CardInformation cardInformation);

    void deleteById(String id);
}
