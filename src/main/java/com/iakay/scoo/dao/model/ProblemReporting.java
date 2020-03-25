package com.iakay.scoo.dao.model;

import com.iakay.scoo.enumeration.PROBLEM_TYPE;
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
public class ProblemReporting {
    @Id
    private String id;
    @NotNull
    private String userId;
    @NotNull
    private String scooterId;

    private String ridingId;

    private PROBLEM_TYPE problemType;

    private String detail;

    private LocalDateTime createTime;
    @NotNull
    private double coordinate;

    private String pictureId;

}
