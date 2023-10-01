package com.bmf.controller;

import com.alibaba.fastjson.JSON;
import com.bmf.design.api.Result;
import com.bmf.design.api.domain.cmd.DomainEventCmdService;
import com.bmf.design.api.domain.dto.DomainEventCmdReqDTO;
import com.bmf.design.api.domain.dto.DomainEventQryReqDTO;
import com.bmf.design.api.domain.dto.DomainEventRespDTO;
import com.bmf.design.api.domain.qry.DomainEventQryService;
import com.bmf.design.base.tactics.event.DomainEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "domain/event")
public class DomainEventController {

    private static final Logger logger = LoggerFactory.getLogger(DomainEventController.class);

    @Autowired
    private DomainEventQryService domainEventQryService;
    @Autowired
    private DomainEventCmdService domainEventCmdService;

    @GetMapping("detail")
    public String detail(@RequestParam("domain_code") Integer domainCode,
                         @RequestParam("event_code") Integer eventCode,
                         @RequestParam("include_all") Boolean includeAll) {
        DomainEventQryReqDTO domainEventQryReqDTO = new DomainEventQryReqDTO();
        DomainEvent domainEvent = new DomainEvent();
        domainEvent.setDomainCode(domainCode);
        domainEvent.setEventCode(eventCode);
        domainEventQryReqDTO.setDomainEvent(domainEvent);
        domainEventQryReqDTO.setIncludeAttr(includeAll);
        Result<DomainEventRespDTO> result = domainEventQryService.queryOne(domainEventQryReqDTO);
        return JSON.toJSONString(result);
    }

    @PostMapping("attr/add")
    public Boolean addEventAttr(@RequestBody DomainEventCmdReqDTO domainEventCmdReqDTO) {
        Result<Boolean> result = domainEventCmdService.addEventAttr(domainEventCmdReqDTO);
        return result.getData();
    }

    @PostMapping("attr/del")
    public Boolean delEventAttr(@RequestBody DomainEventCmdReqDTO domainEventCmdReqDTO) {
        Result<Boolean> result = domainEventCmdService.delEventAttr(domainEventCmdReqDTO);
        return result.getData();
    }
}
