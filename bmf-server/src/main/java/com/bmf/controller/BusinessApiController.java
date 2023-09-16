package com.bmf.controller;

import com.alibaba.fastjson2.JSON;
import com.bmf.api.Result;
import com.bmf.api.application.BusinessApiCmdService;
import com.bmf.api.application.dto.BusinessApiCmdReqDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "business/api")
public class BusinessApiController {

    private static final Logger logger = LoggerFactory.getLogger(BusinessApiController.class);

    @Autowired
    private BusinessApiCmdService businessApiCmdService;

    @PostMapping("create")
    public Boolean create(@RequestBody BusinessApiCmdReqDTO businessApiCmdReqDTO) {
        logger.info("req: {}", JSON.toJSON(businessApiCmdReqDTO));
        Result<Boolean> result = businessApiCmdService.create(businessApiCmdReqDTO);
        return result.getData();
    }

}
