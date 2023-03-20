package com.bmf.controller;

import com.alibaba.fastjson.JSON;
import com.bmf.api.Result;
import com.bmf.api.domain.cmd.DomainEntityCmdService;
import com.bmf.api.domain.dto.DomainEntityCmdReqDTO;
import com.bmf.api.domain.dto.DomainEntityQryReqDTO;
import com.bmf.api.domain.dto.DomainEntityRespDTO;
import com.bmf.api.domain.qry.DomainEntityQryService;
import com.bmf.base.tactics.entity.DomainEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "domain/entity")
public class DomainEntityController {

    private static final Logger logger = LoggerFactory.getLogger(DomainEntityController.class);

    @Autowired
    private DomainEntityQryService domainEntityQryService;
    @Autowired
    private DomainEntityCmdService domainEntityCmdService;

    @GetMapping("detail")
    public String detail(@RequestParam("domain_code") Integer domainCode,
                         @RequestParam("entity_id_code") Integer entityIdCode,
                         @RequestParam("include_all") Boolean includeAll) {
        DomainEntityQryReqDTO domainEntityQryReqDTO = new DomainEntityQryReqDTO();
        DomainEntity domainEntity = new DomainEntity();
        domainEntity.setDomainCode(domainCode);
        domainEntity.setEntityIdCode(entityIdCode);
        domainEntityQryReqDTO.setDomainEntity(domainEntity);
        domainEntityQryReqDTO.setIncludeAttr(includeAll);
        domainEntityQryReqDTO.setIncludeVo(includeAll);
        Result<DomainEntityRespDTO> result = domainEntityQryService.queryOne(domainEntityQryReqDTO);
        return JSON.toJSONString(result);
    }

    @PostMapping("addAttr")
    public Boolean addAttr(@RequestBody DomainEntityCmdReqDTO domainEntityCmdReqDTO) {
        Result<Boolean> result = domainEntityCmdService.addEntityAttr(domainEntityCmdReqDTO);
        return result.getData();
    }
}
