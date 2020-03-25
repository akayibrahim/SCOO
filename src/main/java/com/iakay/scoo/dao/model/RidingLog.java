package com.iakay.scoo.dao.model;

import com.iakay.scoo.enumeration.RIDING_LOG_TYPE;
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
public class RidingLog {
    @Id
    private String ridingId;
    @NotNull
    private RIDING_LOG_TYPE action;
    @NotNull
    private String description;

    private LocalDateTime createTime;

}
