package com.iakay.scoo.controller;

import com.iakay.scoo.dao.model.Pricing;
import com.iakay.scoo.dao.model.Riding;
import com.iakay.scoo.dao.model.RidingCoordinates;
import com.iakay.scoo.dao.repository.PricingRepository;
import com.iakay.scoo.dao.repository.RidingCoordinatesRepository;
import com.iakay.scoo.dao.repository.RidingRepository;
import com.iakay.scoo.enumeration.LOCK_STATUS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

/**
 * Created by iakay on 2020-01-12.
 */
@Api(tags = "Riding Controller")
@RestController(value = "/riding")
@RequestMapping(method = RequestMethod.POST)
public class RidingController {
    @Autowired
    private RidingRepository ridingRepository;
    @Autowired
    private RidingCoordinatesRepository ridingCoordinatesRepository;
    @Autowired
    private PricingRepository pricingRepository;

    @ApiOperation(value = "Get riding history.")
    @RequestMapping(value = "/getHistory")
    public List<Riding> getHistory(String userId) {
        return ridingRepository.findByUserId(userId);
    }

    @ApiOperation(value = "Get riding detail.")
    @RequestMapping(value = "/geDetail")
    public Optional<Riding> geDetail(String id) {
        return ridingRepository.findById(id);
    }

    @ApiOperation(value = "Start to riding.")
    @RequestMapping(value = "/start")
    public Riding start(Riding riding) {
        riding.setLockStatus(LOCK_STATUS.UNLOCKED);
        riding.setStartDateTime(LocalDateTime.now());
        return ridingRepository.save(riding);
    }

    @ApiOperation(value = "Finish riding.")
    @RequestMapping(value = "/finish")
    public Riding finish(String id) {
        Riding riding = ridingRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        List<RidingCoordinates> ridingCoordinates = ridingCoordinatesRepository.findByRidingId(id);
        riding.setTotalDistance(0); // TODO find diff between END and START coordinate.
        riding.setEndDateTime(LocalDateTime.now());
        riding.setTotalTime(ChronoUnit.MINUTES.between(riding.getStartDateTime(), riding.getEndDateTime()));
        Pricing pricing = pricingRepository.findByCreateTime(Sort.by(Sort.Direction.DESC, "createTime")).orElseThrow(IllegalArgumentException::new);
        riding.setTotalPrice(pricing.getPriceOfStart() + riding.getTotalTime() * pricing.getPriceOfMinute());
        riding.setLockStatus(LOCK_STATUS.LOCKED);
        return ridingRepository.save(riding);
    }
}