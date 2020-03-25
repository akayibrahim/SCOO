package com.iakay.scoo.dao.model;

import com.iakay.scoo.enumeration.USER_ACTION_TYPE;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by iakay on 2020-01-02.
 */
@Data
@Document
public class UserLog {
    @Id
    private String userId;

    private USER_ACTION_TYPE action;

    private String description;

    private LocalDateTime createTime;

}
