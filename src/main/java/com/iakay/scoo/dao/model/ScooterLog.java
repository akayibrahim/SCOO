package com.iakay.scoo.dao.model;

import com.iakay.scoo.enumeration.SCOOTER_ACTION;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by iakay on 2020-01-02.
 */
@Data
@Document
public class ScooterLog {
    @Id
    private String scooterId;

    private SCOOTER_ACTION action;

    private String description;

    private LocalDateTime createTime;

}
