package com.iakay.scoo.dao.model;

import com.iakay.scoo.enumeration.BAND_TYPE;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by iakay on 2020-01-02.
 */
@Data
@Document
public class Scooter {
    @Id
    private String id;

    @NotNull
    private BAND_TYPE band;

    private LocalDateTime createTime;
    @NotNull
    private double purchaseValue;
    @NotNull
    private String gpsId;
    @NotNull
    private int gpsPhoneNumber;

    private String lockId;
    @NotNull
    private int lockPassword;

    private double lastLatitude;

    private double lastLongitude;

    private int lastBattery;

    private String label;
}
