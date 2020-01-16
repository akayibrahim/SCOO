package com.iakay.scoo.dao.model;

import com.iakay.scoo.enumeration.BAND;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by iakay on 2020-01-02.
 */
@Data
@Document
public class Scooter {
    @Id
    private String id;

    private BAND band;

    private LocalDateTime createTime;

    private double purchaseValue;

    private String gpsId;

    private int gpsPhoneNumber;

    private String lockId;

    private int lockPassword;

}
