package com.bmf.controller;

import com.alibaba.fastjson2.JSON;
import com.bmf.api.Result;
import com.bmf.api.application.DomainApiCmdService;
import com.bmf.api.application.DomainApiQryService;
import com.bmf.api.application.dto.DomainApiCmdReqDTO;
import com.bmf.api.application.dto.DomainApiQryReqDTO;
import com.bmf.api.application.dto.DomainApiRespDTO;
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
    @Autowired
    private DomainApiQryService domainApiQryService;

    @PostMapping("create")
    public Boolean create(@RequestBody DomainApiCmdReqDTO domainApiCmdReqDTO) {
        logger.info("req: {}", JSON.toJSON(domainApiCmdReqDTO));
        Result<Boolean> result = domainApiCmdService.create(domainApiCmdReqDTO);
        return result.getData();
    }

    @GetMapping("detail")
    public Result<DomainApiRespDTO> detail(@RequestParam("domain_code") Integer domainCode) {
        DomainApiQryReqDTO reqDTO = new DomainApiQryReqDTO();
        reqDTO.setDomainCode(domainCode);
        return domainApiQryService.queryOne(reqDTO);
    }
}
