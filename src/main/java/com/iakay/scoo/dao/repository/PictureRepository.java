package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.Picture;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */

@Repository
public interface PictureRepository extends MongoRepository<Picture, String> {
    Optional<Picture> findById(String id);

    Picture save(Picture picture);

    void deleteById(String id);
}
