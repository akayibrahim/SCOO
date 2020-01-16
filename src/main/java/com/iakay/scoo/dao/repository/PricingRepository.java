package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.Pricing;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */

@Repository
public interface PricingRepository extends MongoRepository<Pricing, String> {
    Optional<Pricing> findByCreateTime(Sort sort);

    Pricing save(Pricing pricing);

    void deleteById(String id);
}
