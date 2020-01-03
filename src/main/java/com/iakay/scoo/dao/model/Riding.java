package com.iakay.scoo.dao.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.iakay.scoo.enumeration.BAND;
import com.iakay.scoo.enumeration.LOCK_STATUS;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by iakay on 2020-01-02.
 */
@Data
@DynamoDBTable(tableName = "Riding")
public class Riding {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id;
    @DynamoDBAttribute
    private String userId;
    @DynamoDBAttribute
    private String scooterId;
    @DynamoDBAttribute
    private String coordinateId;
    @DynamoDBAttribute
    private LocalDateTime startDateTime;
    @DynamoDBAttribute
    private LocalDateTime endDateTime;
    @DynamoDBAttribute
    private double totalTime;
    @DynamoDBAttribute
    private double totalPrice;
    @DynamoDBAttribute
    private double totalDistance;
    @DynamoDBAttribute
    private String pictureId;
    @DynamoDBAttribute
    private LOCK_STATUS lockStatus;

}