package com.bmf.controller;

import com.alibaba.fastjson2.JSON;
import com.bmf.common.api.Result;
import com.bmf.dev.api.application.DomainAppCmdService;
import com.bmf.dev.api.application.DomainAppQryService;
import com.bmf.dev.api.application.dto.DomainAppCmdReqDTO;
import com.bmf.dev.api.application.dto.DomainAppQryReqDTO;
import com.bmf.dev.api.application.dto.DomainAppRespDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "domain/api")
public class DomainApiController {

    private static final Logger logger = LoggerFactory.getLogger(DomainApiController.class);

    @Autowired
    private DomainAppCmdService domainAppCmdService;
    @Autowired
    private DomainAppQryService domainAppQryService;

    @PostMapping("create")
    public Boolean create(@RequestBody DomainAppCmdReqDTO domainAppCmdReqDTO) {
        logger.info("req: {}", JSON.toJSON(domainAppCmdReqDTO));
        Result<Boolean> result = domainAppCmdService.create(domainAppCmdReqDTO);
        return result.getData();
    }

    @GetMapping("detail")
    public Result<DomainAppRespDTO> detail(@RequestParam("domain_code") Integer domainCode) {
        DomainAppQryReqDTO reqDTO = new DomainAppQryReqDTO();
        reqDTO.setDomainCode(domainCode);
        return domainAppQryService.queryOne(reqDTO);
    }
}
