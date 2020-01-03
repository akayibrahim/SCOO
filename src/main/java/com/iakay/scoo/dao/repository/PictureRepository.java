package com.iakay.scoo.dao.repository;

import com.iakay.scoo.dao.model.Picture;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by iakay on 2019-12-22.
 */
@EnableScan
@Repository
public interface PictureRepository extends CrudRepository<Picture, String> {
    Optional<Picture> findById(String id);

    Picture save(Picture picture);

    void deleteById(String id);
}
