package com.bmf.controller;

import com.alibaba.fastjson2.JSON;
import com.bmf.api.Result;
import com.bmf.api.application.DomainApiCmdService;
import com.bmf.api.application.dto.DomainApiCmdReqDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "domain/api")
public class DomainApiController {

    private static final Logger logger = LoggerFactory.getLogger(DomainApiController.class);

    @Autowired
    private DomainApiCmdService domainApiCmdService;

    @PostMapping("create")
    public Boolean create(@RequestBody DomainApiCmdReqDTO domainApiCmdReqDTO) {
        logger.info("req: {}", JSON.toJSON(domainApiCmdReqDTO));
        Result<Boolean> result = domainApiCmdService.create(domainApiCmdReqDTO);
        return result.getData();
    }

}
