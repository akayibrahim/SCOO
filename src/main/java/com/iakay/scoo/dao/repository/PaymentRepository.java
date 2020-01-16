package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.Payment;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
    Optional<Payment> findById(String id);

    Payment save(Payment payment);

    void deleteById(String id);
}
