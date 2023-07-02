package com.bmf.controller;

import com.alibaba.fastjson.JSON;
import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.BusinessQryService;
import com.bmf.api.business.dto.BusinessCmdReqDTO;
import com.bmf.api.business.dto.BusinessQryReqDTO;
import com.bmf.api.business.dto.BusinessRespDTO;
import com.bmf.base.Business;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "business")
public class BusinessController {

    private static final Logger logger = LoggerFactory.getLogger(BusinessController.class);

    @Autowired
    private BusinessQryService businessQryService;
    @Autowired
    private BusinessCmdService businessCmdService;

    @GetMapping("detail")
    public String detail(@RequestParam("business_code") Integer businessCode,
                         @RequestParam("include_all") Boolean includeAll) {
        BusinessQryReqDTO businessQryReqDTO = new BusinessQryReqDTO();
        Business business = new Business();
        business.setBusinessCode(businessCode);
        businessQryReqDTO.setBusiness(business);
        businessQryReqDTO.setIncludeDomain(includeAll);
        businessQryReqDTO.setIncludeDomainRelation(includeAll);
        Result<BusinessRespDTO> result = businessQryService.queryOne(businessQryReqDTO);
        return JSON.toJSONString(result);
    }

    @PostMapping("create")
    public Boolean create(@RequestBody BusinessCmdReqDTO businessCmdReqDTO) {
        Result<Boolean> result = businessCmdService.create(businessCmdReqDTO);
        return result.getData();
    }

    @PostMapping("strategy/design/save")
    public Boolean saveStrategyDesign(@RequestBody BusinessCmdReqDTO businessCmdReqDTO) {
        Result<Boolean> result = businessCmdService.saveStrategyDesign(businessCmdReqDTO);
        return result.getData();
    }

    @PostMapping("domain/add")
    public Boolean addDomain(@RequestBody BusinessCmdReqDTO businessCmdReqDTO) {
        Result<Boolean> result = businessCmdService.addDomain(businessCmdReqDTO);
        return result.getData();
    }

    @PostMapping("domain/del")
    public Boolean delDomain(@RequestBody BusinessCmdReqDTO businessCmdReqDTO) {
        Result<Boolean> result = businessCmdService.delDomain(businessCmdReqDTO);
        return result.getData();
    }

    @PostMapping("domain/relation/add")
    public Boolean addDomainRelation(@RequestBody BusinessCmdReqDTO businessCmdReqDTO) {
        Result<Boolean> result = businessCmdService.buildDomainRelation(businessCmdReqDTO);
        return result.getData();
    }

    @PostMapping("domain/relation/del")
    public Boolean delDomainRelation(@RequestBody BusinessCmdReqDTO businessCmdReqDTO) {
        Result<Boolean> result = businessCmdService.removeDomainRelation(businessCmdReqDTO);
        return result.getData();
    }
}
