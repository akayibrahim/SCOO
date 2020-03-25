package com.iakay.scoo.controller;

import com.iakay.scoo.dao.model.Scooter;
import com.iakay.scoo.dao.repository.ScooterRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by iakay on 2020-01-12.
 */
@Api(tags = "Scooter Controller")
@RestController
@RequestMapping(value = "/scooter", method = RequestMethod.POST)
@Transactional
@Validated
public class ScooterController {
    @Autowired
    private ScooterRepository scooterRepository;

    @ApiOperation(value = "Adding New Scooter.")
    @RequestMapping(value = "/add")
    public Scooter add(@Valid @RequestBody Scooter scooter) {
        scooter.setCreateTime(LocalDateTime.now());
        return scooterRepository.save(scooter);
    }

    @ApiOperation(value = "Delete all.")
    @RequestMapping(value = "/deleteAll")
    public void delete() {
        scooterRepository.deleteAll();
    }

    @ApiOperation(value = "Get closest scooters for map.")
    @RequestMapping(value = "/getClosestScooters")
    public List<Scooter> getClosestScooters(@Valid @RequestParam @NotNull double latitude, @RequestParam @NotNull double longitude) {
        return scooterRepository.findAll(); // TODO filter with coordinates that use gpsId
    }

    @ApiOperation(value = "Get scooter detail.")
    @RequestMapping(value = "/get")
    @Valid
    public Optional<Scooter> get(@RequestParam @NotNull String id) {
        return scooterRepository.findById(id);
    }

    @ApiOperation(value = "Get scooter detail by label.")
    @RequestMapping(value = "/getByLabel")
    @Valid
    public Optional<Scooter> getByLabel(@RequestParam @NotNull String label) {
        return scooterRepository.findByLabel(label);
    }

    @ApiOperation(value = "Power on.")
    @RequestMapping(value = "/powerOn")
    public void powerOn(@Valid @RequestParam @NotNull String id) {
        // Scooter scooter = scooterRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        // TODO power on via GPS.
    }

    @ApiOperation(value = "Power off.")
    @RequestMapping(value = "/powerOff")
    public void powerOff(@Valid @RequestParam @NotNull String id) {
        // Scooter scooter = scooterRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        // TODO power off via GPS.
    }

    @ApiOperation(value = "Update lock pass by label.")
    @RequestMapping(value = "/updateLockPassByLabel")
    public void updateLockPassByLabel(@RequestParam @NotNull String label, @RequestParam @NotNull Integer pass) {
        Scooter scoo = scooterRepository.findByLabel(label).get();
        scoo.setLockPassword(pass);
        scooterRepository.save(scoo);
    }
}
