package com.iakay.scoo.dao.model;

import com.iakay.scoo.enumeration.RIDING_STATUS;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by iakay on 2020-01-02.
 */
@Data
@Document
public class RidingCoordinates {
    @Id
    private String id;

    private String ridingId;

    private double latitude;

    private double longitude;

    private RIDING_STATUS status;

    private double distance;

    private LocalDateTime createTime;

}
