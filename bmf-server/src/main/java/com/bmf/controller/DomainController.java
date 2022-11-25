package com.bmf.controller;

import com.alibaba.fastjson.JSON;
import com.bmf.api.Result;
import com.bmf.api.domain.DomainCmdService;
import com.bmf.api.domain.DomainQryService;
import com.bmf.api.domain.DomainReqDTO;
import com.bmf.api.domain.DomainRespDTO;
import com.bmf.base.BusinessDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "domain")
public class DomainController {

    private static final Logger logger = LoggerFactory.getLogger(DomainController.class);

    @Autowired
    private DomainQryService domainQryService;
    @Autowired
    private DomainCmdService domainCmdService;

    @GetMapping("list")
    public String list() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(10);
        domainReqDTO.setBusinessDomain(businessDomain);
        Result<DomainRespDTO> result = domainQryService.queryOne(domainReqDTO);
        return JSON.toJSONString(result);
    }

    @GetMapping("detail")
    public String detail() {
        return JSON.toJSONString(null);
    }
}
