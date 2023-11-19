package com.bmf.controller;

import com.bmf.common.api.Result;
import com.bmf.design.api.business.BusinessCmdService;
import com.bmf.design.api.business.BusinessQryService;
import com.bmf.design.api.business.dto.BusinessCmdReqDTO;
import com.bmf.design.api.business.dto.BusinessQryReqDTO;
import com.bmf.design.model.Business;
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
    public Result detail(@RequestParam("business_code") Integer businessCode,
                         @RequestParam("include_all") Boolean includeAll) {
        BusinessQryReqDTO businessQryReqDTO = new BusinessQryReqDTO();
        Business business = new Business();
        business.setBusinessCode(businessCode);
        businessQryReqDTO.setBusiness(business);
        businessQryReqDTO.setIncludeDomain(includeAll);
        businessQryReqDTO.setIncludeDomainRelation(includeAll);
        return businessQryService.queryOne(businessQryReqDTO);
    }

    @PostMapping("create")
    public Result create(@RequestBody BusinessCmdReqDTO businessCmdReqDTO) {
        return businessCmdService.create(businessCmdReqDTO);
    }

    @PostMapping("strategy/design/save")
    public Result saveStrategyDesign(@RequestBody BusinessCmdReqDTO businessCmdReqDTO) {
        return businessCmdService.saveStrategyDesign(businessCmdReqDTO);
    }

    @PostMapping("domain/add")
    public Result addDomain(@RequestBody BusinessCmdReqDTO businessCmdReqDTO) {
        return businessCmdService.addDomain(businessCmdReqDTO);
    }

    @PostMapping("domain/del")
    public Result delDomain(@RequestBody BusinessCmdReqDTO businessCmdReqDTO) {
        return businessCmdService.delDomain(businessCmdReqDTO);
    }

    @PostMapping("domain/relation/add")
    public Result addDomainRelation(@RequestBody BusinessCmdReqDTO businessCmdReqDTO) {
        return businessCmdService.buildDomainRelation(businessCmdReqDTO);
    }

    @PostMapping("domain/relation/del")
    public Result delDomainRelation(@RequestBody BusinessCmdReqDTO businessCmdReqDTO) {
        return businessCmdService.removeDomainRelation(businessCmdReqDTO);
    }
}
