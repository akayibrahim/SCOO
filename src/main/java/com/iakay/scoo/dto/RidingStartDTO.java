package com.iakay.scoo.dto;

import com.iakay.scoo.dao.model.Riding;
import com.iakay.scoo.dao.model.RidingCoordinates;
import lombok.Data;

/**
 * Created by iakay on 2020-01-27.
 */
@Data
public class RidingStartDTO {
    private Riding riding;
    private RidingCoordinates ridingCoordinates;
}
