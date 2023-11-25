package com.bmf.controller;

import com.alibaba.fastjson.JSON;
import com.bmf.common.api.Result;
import com.bmf.design.api.domain.cmd.DomainCmdService;
import com.bmf.design.api.domain.dto.DomainCmdReqDTO;
import com.bmf.design.api.domain.qry.DomainQryService;
import com.bmf.design.api.domain.dto.DomainQryReqDTO;
import com.bmf.design.api.domain.dto.DomainRespDTO;
import com.bmf.design.model.Domain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "domain")
public class DomainController {

    private static final Logger logger = LoggerFactory.getLogger(DomainController.class);

    @Autowired
    private DomainQryService domainQryService;
    @Autowired
    private DomainCmdService domainCmdService;

    @GetMapping("detail")
    public String detail(@RequestParam("domain_code") Integer domainCode,
                         @RequestParam("include_all") Boolean includeAll) {
        DomainQryReqDTO domainQryReqDTO = new DomainQryReqDTO();
        Domain domain = new Domain();
        domain.setDomainCode(domainCode);
        domainQryReqDTO.setDomain(domain);
        domainQryReqDTO.setIncludeEntity(includeAll);
        domainQryReqDTO.setIncludeService(includeAll);
        domainQryReqDTO.setIncludeEvent(includeAll);
        Result<DomainRespDTO> result = domainQryService.queryOne(domainQryReqDTO);
        return JSON.toJSONString(result);
    }

    @PostMapping("create")
    public Boolean create(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        return result.getData();
    }

    @PostMapping("entity/add")
    public Result<Boolean> addEntity(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        return domainCmdService.addEntity(domainCmdReqDTO);
    }

    @PostMapping("entity/del")
    public Result<Boolean> delEntity(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        return domainCmdService.delEntity(domainCmdReqDTO);
    }

    @PostMapping("vo/add")
    public Boolean addValueObject(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        Result<Boolean> result = domainCmdService.addValueObject(domainCmdReqDTO);
        return result.getData();
    }

    @PostMapping("vo/del")
    public Boolean delValueObject(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        Result<Boolean> result = domainCmdService.delValueObject(domainCmdReqDTO);
        return result.getData();
    }

    @PostMapping("entity/vo/add")
    public Boolean addEntityRelVO(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        Result<Boolean> result = domainCmdService.addEntityRelVO(domainCmdReqDTO);
        return result.getData();
    }

    @PostMapping("entity/vo/del")
    public Boolean delEntityRelVO(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        Result<Boolean> result = domainCmdService.delEntityRelVO(domainCmdReqDTO);
        return result.getData();
    }

    @PostMapping("service/add")
    public Boolean addService(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        Result<Boolean> result = domainCmdService.addService(domainCmdReqDTO);
        return result.getData();
    }

    @PostMapping("service/del")
    public Boolean delService(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        Result<Boolean> result = domainCmdService.delService(domainCmdReqDTO);
        return result.getData();
    }

    @PostMapping("event/add")
    public Boolean addEvent(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        Result<Boolean> result = domainCmdService.addEvent(domainCmdReqDTO);
        return result.getData();
    }

    @PostMapping("event/del")
    public Boolean delEvent(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        Result<Boolean> result = domainCmdService.delEvent(domainCmdReqDTO);
        return result.getData();
    }

    @PostMapping("dsl/add")
    public Boolean addDsl(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        Result<Boolean> result = domainCmdService.addDsl(domainCmdReqDTO);
        return result.getData();
    }

    @PostMapping("dsl/del")
    public Boolean delDsl(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        Result<Boolean> result = domainCmdService.delDsl(domainCmdReqDTO);
        return result.getData();
    }
}
