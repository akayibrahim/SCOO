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
public class Pricing {
    @Id
    private String id;

    private double priceOfStart;

    private double priceOfMinute;

    private int taxRatio;

    private LocalDateTime createTime;

}
