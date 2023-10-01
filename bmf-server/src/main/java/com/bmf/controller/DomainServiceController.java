package com.bmf.controller;

import com.alibaba.fastjson.JSON;
import com.bmf.design.api.Result;
import com.bmf.design.api.domain.cmd.DomainServiceCmdService;
import com.bmf.design.api.domain.dto.DomainServiceCmdReqDTO;
import com.bmf.design.api.domain.dto.DomainServiceQryReqDTO;
import com.bmf.design.api.domain.dto.DomainServiceRespDTO;
import com.bmf.design.api.domain.qry.DomainServiceQryService;
import com.bmf.design.base.tactics.service.DomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "domain/service")
public class DomainServiceController {

    private static final Logger logger = LoggerFactory.getLogger(DomainServiceController.class);

    @Autowired
    private DomainServiceQryService domainServiceQryService;
    @Autowired
    private DomainServiceCmdService domainServiceCmdService;

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

    @PostMapping("attr/add")
    public Boolean addServiceAttr(@RequestBody DomainServiceCmdReqDTO domainServiceCmdReqDTO) {
        Result<Boolean> result = domainServiceCmdService.addServiceAttr(domainServiceCmdReqDTO);
        return result.getData();
    }

    @PostMapping("attr/del")
    public Boolean delServiceAttr(@RequestBody DomainServiceCmdReqDTO domainServiceCmdReqDTO) {
        Result<Boolean> result = domainServiceCmdService.delServiceAttr(domainServiceCmdReqDTO);
        return result.getData();
    }
}
