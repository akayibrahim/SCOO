package com.iakay.scoo.dao.model;

import com.iakay.scoo.enumeration.ALERT;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by iakay on 2020-01-02.
 */
@Data
@Document
public class Alert {
    @Id
    private String id;
    private String userId;
    private String scooterId;
    private String ridingId;
    private String problemId;
    private ALERT type;
    private String detail;
    private LocalDateTime createTime;
}
