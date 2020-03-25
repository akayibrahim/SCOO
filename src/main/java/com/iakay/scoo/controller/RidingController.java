package com.iakay.scoo.controller;

import com.iakay.scoo.dao.model.Picture;
import com.iakay.scoo.dao.model.Pricing;
import com.iakay.scoo.dao.model.Riding;
import com.iakay.scoo.dao.model.RidingCoordinates;
import com.iakay.scoo.dao.repository.PictureRepository;
import com.iakay.scoo.dao.repository.PricingRepository;
import com.iakay.scoo.dao.repository.RidingCoordinatesRepository;
import com.iakay.scoo.dao.repository.RidingRepository;
import com.iakay.scoo.dto.RidingStartDTO;
import com.iakay.scoo.enumeration.LOCK_STATUS_TYPE;
import com.iakay.scoo.enumeration.PICTURE_REASON_TYPE;
import com.iakay.scoo.enumeration.RIDING_STATUS_TYPE;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

/**
 * Created by iakay on 2020-01-12.
 */
@Api(tags = "Riding Controller")
@RestController
@RequestMapping(value = "/riding", method = RequestMethod.POST)
@Transactional
@Validated
public class RidingController {
    @Autowired
    private RidingRepository ridingRepository;
    @Autowired
    private RidingCoordinatesRepository ridingCoordinatesRepository;
    @Autowired
    private PricingRepository pricingRepository;
    @Autowired
    private PictureRepository pictureRepository;
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @ApiOperation(value = "Get riding history.")
    @RequestMapping(value = "/history")
    @Valid
    public List<Riding> history(@RequestParam @NotEmpty String userId) {
        return ridingRepository.findByUserId(userId);
    }

    @ApiOperation(value = "Get riding detail.")
    @RequestMapping(value = "/detail")
    @Valid
    public Optional<Riding> detail(@RequestParam @NotEmpty String id) {
        return ridingRepository.findById(id);
    }

    @ApiOperation(value = "Start to riding.")
    @RequestMapping(value = "/start")
    public Riding start(@Valid @RequestBody RidingStartDTO ridingStartDTO) {
        ridingStartDTO.getRiding().setLockStatus(LOCK_STATUS_TYPE.UNLOCKED);
        ridingStartDTO.getRiding().setStartDateTime(LocalDateTime.now());
        Riding savedRiding = ridingRepository.save(ridingStartDTO.getRiding());
        saveCoordinate(ridingStartDTO.getRidingCoordinates(), savedRiding, RIDING_STATUS_TYPE.START);
        return savedRiding;
    }

    @ApiOperation(value = "Finish riding.")
    @RequestMapping(value = "/finish")
    @Valid
    public Riding finish(@RequestBody RidingCoordinates ridingCoordinate) {
        Riding riding = ridingRepository.findById(ridingCoordinate.getRidingId()).orElseThrow(IllegalArgumentException::new);
        saveCoordinate(ridingCoordinate, riding, RIDING_STATUS_TYPE.END);
        Pricing pricing = pricingRepository.findByCreateTime(Sort.by(Sort.Direction.DESC, "createTime")).orElseThrow(IllegalArgumentException::new);
        double distance = getDistance(ridingCoordinate.getRidingId());
        riding.setTotalDistance(distance);
        riding.setEndDateTime(LocalDateTime.now());
        riding.setTotalTime(ChronoUnit.MINUTES.between(riding.getStartDateTime(), riding.getEndDateTime()));
        riding.setTotalPrice(pricing.getPriceOfStart() + riding.getTotalTime() * pricing.getPriceOfMinute());
        riding.setLockStatus(LOCK_STATUS_TYPE.LOCKED);
        return ridingRepository.save(riding);
    }

    private double getDistance(String id) {
        List<RidingCoordinates> ridingCoordinates = ridingCoordinatesRepository.findByRidingId(id);
        return 0;// TODO find diff between END and START coordinate.
    }

    private void saveCoordinate(RidingCoordinates ridingCoordinate, Riding riding, RIDING_STATUS_TYPE end) {
        ridingCoordinate.setRidingId(riding.getId());
        ridingCoordinate.setStatus(end);
        ridingCoordinate.setCreateTime(LocalDateTime.now());
        ridingCoordinatesRepository.save(ridingCoordinate);
    }

    @ApiOperation(value = "Take a picture when riding finish.")
    @RequestMapping(value = "/addPicture")
    @Valid
    public Picture addPicture(@RequestParam @NotEmpty MultipartFile file, @RequestBody Picture picture) throws IOException {
        String pictureGridFsId = savePicture(file, picture);
        picture.setPictureGridFsId(pictureGridFsId);
        picture.setCreateTime(LocalDateTime.now());
        picture.setReason(PICTURE_REASON_TYPE.RIDING);
        return pictureRepository.save(picture);
    }

    private String savePicture(MultipartFile file, Picture picture) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("ridingId", picture.getRidingId());
        metaData.put("problemId", picture.getProblemId());
        InputStream inputStream = file.getInputStream();
        String type[] = file.getContentType().split("/");
        metaData.put("type", type[0]);
        return gridFsTemplate.store(inputStream, file.getOriginalFilename(), file.getContentType(), metaData).toString();
    }

    @ApiOperation(value = "Add new coordinates.")
    @RequestMapping(value = "/addCoordinate")
    public void addCoordinate(@Valid @RequestBody RidingCoordinates ridingCoordinates) {
        ridingCoordinates.setStatus(RIDING_STATUS_TYPE.ON_THE_WAY);
        ridingCoordinates.setCreateTime(LocalDateTime.now());
        ridingCoordinatesRepository.save(ridingCoordinates);
    }

    @ApiOperation(value = "Get coordinates.")
    @RequestMapping(value = "/getCoordinates")
    @Valid
    public List<RidingCoordinates> getCoordinates(@RequestParam @NotEmpty String id) {
        return ridingCoordinatesRepository.findByRidingId(id);
    }
}