package com.iakay.scoo.dao.model;

import com.iakay.scoo.enumeration.RIDING_STATUS_TYPE;
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
public class RidingCoordinates {
    @Id
    private String id;
    @NotNull
    private String ridingId;
    @NotNull
    private double latitude;
    @NotNull
    private double longitude;
    @NotNull
    private RIDING_STATUS_TYPE status;

    private LocalDateTime createTime;

}
