package com.iakay.scoo.dao.model;

import com.iakay.scoo.enumeration.SUCCESS_TYPE;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by iakay on 2020-01-02.
 */
@Data
@Document
public class Payment {
    @Id
    private String id;

    private String userId;

    private String scooterId;

    private String ridingId;

    private SUCCESS_TYPE success;

    private double price;

    private double tax;

    private LocalDateTime createTime;

}
