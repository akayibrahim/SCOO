package com.iakay.scoo.controller;

import com.iakay.scoo.dao.model.ProblemReporting;
import com.iakay.scoo.dao.repository.ProblemReportingRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * Created by iakay on 2020-01-18.
 */
@Api(tags = "Problem Controller")
@RestController
@RequestMapping(value = "/problem", method = RequestMethod.POST)
@Transactional
@Validated
public class ProblemController {
    @Autowired
    private ProblemReportingRepository problemReportingRepository;

    @ApiOperation(value = "Get a problem issue.")
    @RequestMapping(value = "/report")
    public ProblemReporting report(@Valid @RequestBody ProblemReporting problemReporting) {
        problemReporting.setCreateTime(LocalDateTime.now());
        return problemReportingRepository.save(problemReporting);
    }
}