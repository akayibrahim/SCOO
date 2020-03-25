package com.iakay.scoo.dao.model;

import com.iakay.scoo.enumeration.LOCK_STATUS_TYPE;
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
public class Riding {
    @Id
    private String id;
    @NotNull
    private String userId;
    @NotNull
    private String scooterId;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private double totalTime;

    private double totalPrice;

    private double totalDistance;

    private String pictureId;

    private LOCK_STATUS_TYPE lockStatus;
}
