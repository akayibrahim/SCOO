package com.iakay.scoo.dao.model;

import com.iakay.scoo.enumeration.PICTURE_REASON_TYPE;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by iakay on 2020-01-02.
 */
@Data
@Document
public class Picture {
    @Id
    private String id;

    private String ridingId;

    private String problemId;

    private PICTURE_REASON_TYPE reason;

    private LocalDateTime createTime;

    private String pictureGridFsId;
}
