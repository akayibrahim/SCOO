package com.iakay.scoo.dao.model;

import com.iakay.scoo.enumeration.RIDING_LOG;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by iakay on 2020-01-02.
 */
@Data
@Document
public class RidingLog {
    @Id
    private String ridingId;

    private RIDING_LOG action;

    private String description;

    private LocalDateTime createTime;

}
