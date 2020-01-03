package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.Pricing;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */
@EnableScan
@Repository
public interface PricingRepository extends CrudRepository<Pricing, String> {
    Optional<Pricing> findById(String id);

    Pricing save(Pricing pricing);

    void deleteById(String id);
}
