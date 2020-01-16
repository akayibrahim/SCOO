package com.iakay.scoo.dao.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by iakay on 2020-01-02.
 */
@Data
@Document
public class CardInformation {
    @Id
    private String id;

    private String userId;

    private String name;

    private String surname;

    private long number;

    private int expireDate;

    private int cvv;

    private LocalDateTime createTime;
}
