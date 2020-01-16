package com.iakay.scoo.controller;

import com.iakay.scoo.dao.model.Scooter;
import com.iakay.scoo.dao.repository.ScooterRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by iakay on 2020-01-12.
 */
@Api(tags = "Scooter Controller")
@RestController(value = "/scooter")
@RequestMapping(method = RequestMethod.POST)
public class ScooterController {
    @Autowired
    private ScooterRepository scooterRepository;

    @ApiOperation(value = "Adding New Scooter.")
    @RequestMapping(value = "/add")
    public Scooter add(Scooter scooter) {
        scooter.setCreateTime(LocalDateTime.now());
        return scooterRepository.save(scooter);
    }

    @ApiOperation(value = "Get closest scooters for map.")
    @RequestMapping(value = "/getClosestScooters")
    public List<Scooter> getClosestScooters(double latitude, double longitude) {
        return scooterRepository.findAll(); // TODO filter with coordinates that use gpsId
    }

    @ApiOperation(value = "Get scooter detail.")
    @RequestMapping(value = "/get")
    public Optional<Scooter> get(String id) {
        return scooterRepository.findById(id);
    }

    @ApiOperation(value = "Power on.")
    @RequestMapping(value = "/powerOn")
    public void powerOn(String id) {
        Scooter scooter = scooterRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        // TODO powen on via GPS.
    }

    @ApiOperation(value = "Power off.")
    @RequestMapping(value = "/powerOff")
    public void powerOff(String id) {
        Scooter scooter = scooterRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        // TODO powen off via GPS.
    }
}
