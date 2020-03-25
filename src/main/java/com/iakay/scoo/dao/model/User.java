package com.iakay.scoo.dao.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
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
    @NotNull
    private String email;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    private String phoneNumber;

    private String password;

    private LocalDate birthDate;

    private String appleId;

    private LocalDateTime createTime;

    private UserLog userLog1;
}
