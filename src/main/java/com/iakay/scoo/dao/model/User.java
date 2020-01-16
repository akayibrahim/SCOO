package com.iakay.scoo.dao.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by iakay on 2019-12-22.
 */
@Data
@Document
public class User {
    @Id
    private String id;

    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String password;

    private LocalDate birthDate;

    private String appleId;

    private LocalDateTime createTime;

}
