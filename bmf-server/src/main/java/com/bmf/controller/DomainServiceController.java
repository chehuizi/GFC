package com.bmf.controller;

import com.alibaba.fastjson.JSON;
import com.bmf.api.Result;
import com.bmf.api.domain.dto.DomainEntityQryReqDTO;
import com.bmf.api.domain.dto.DomainEntityRespDTO;
import com.bmf.api.domain.dto.DomainServiceQryReqDTO;
import com.bmf.api.domain.dto.DomainServiceRespDTO;
import com.bmf.api.domain.qry.DomainServiceQryService;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.service.DomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "domain/service")
public class DomainServiceController {

    private static final Logger logger = LoggerFactory.getLogger(DomainServiceController.class);

    @Autowired
    private DomainServiceQryService domainServiceQryService;

    @GetMapping("detail")
    public String detail(@RequestParam("domain_code") Integer domainCode,
                         @RequestParam("service_code") Integer serviceCode,
                         @RequestParam("include_all") Boolean includeAll) {
        DomainServiceQryReqDTO domainServiceQryReqDTO = new DomainServiceQryReqDTO();
        DomainService domainService = new DomainService();
        domainService.setDomainCode(domainCode);
        domainService.setServiceCode(serviceCode);
        domainServiceQryReqDTO.setDomainService(domainService);
        domainServiceQryReqDTO.setIncludeAttr(includeAll);
        Result<DomainServiceRespDTO> result = domainServiceQryService.queryOne(domainServiceQryReqDTO);
        return JSON.toJSONString(result);
    }

}
