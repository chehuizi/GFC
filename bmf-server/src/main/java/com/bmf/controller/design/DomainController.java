package com.bmf.controller.design;

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
@RequestMapping(path = "design/domain")
public class DomainController {

    private static final Logger logger = LoggerFactory.getLogger(DomainController.class);

    @Autowired
    private DomainQryService domainQryService;
    @Autowired
    private DomainCmdService domainCmdService;

    @GetMapping("detail")
    public Result<DomainRespDTO> detail(@RequestParam("domain_code") Integer domainCode,
                         @RequestParam("include_all") Boolean includeAll) {
        DomainQryReqDTO domainQryReqDTO = new DomainQryReqDTO();
        Domain domain = new Domain();
        domain.setDomainCode(domainCode);
        domainQryReqDTO.setDomain(domain);
        domainQryReqDTO.setIncludeEntity(includeAll);
        domainQryReqDTO.setIncludeService(includeAll);
        domainQryReqDTO.setIncludeEvent(includeAll);
        return domainQryService.queryOne(domainQryReqDTO);
    }

    @PostMapping("create")
    public Result<Boolean> create(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        return domainCmdService.create(domainCmdReqDTO);
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
    public Result<Boolean> addValueObject(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        return domainCmdService.addValueObject(domainCmdReqDTO);
    }

    @PostMapping("vo/del")
    public Result<Boolean> delValueObject(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        return domainCmdService.delValueObject(domainCmdReqDTO);
    }

    @PostMapping("entity/vo/add")
    public Result<Boolean> addEntityRelVO(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        return domainCmdService.addEntityRelVO(domainCmdReqDTO);
    }

    @PostMapping("entity/vo/del")
    public Result<Boolean> delEntityRelVO(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        return domainCmdService.delEntityRelVO(domainCmdReqDTO);
    }

    @PostMapping("service/add")
    public Result<Boolean> addService(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        return domainCmdService.addService(domainCmdReqDTO);
    }

    @PostMapping("service/del")
    public Result<Boolean> delService(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        return domainCmdService.delService(domainCmdReqDTO);
    }

    @PostMapping("event/add")
    public Result<Boolean> addEvent(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        return domainCmdService.addEvent(domainCmdReqDTO);
    }

    @PostMapping("event/del")
    public Result<Boolean> delEvent(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        return domainCmdService.delEvent(domainCmdReqDTO);
    }

    @PostMapping("dsl/add")
    public Result<Boolean> addDsl(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        return domainCmdService.addDsl(domainCmdReqDTO);
    }

    @PostMapping("dsl/del")
    public Result<Boolean> delDsl(@RequestBody DomainCmdReqDTO domainCmdReqDTO) {
        return domainCmdService.delDsl(domainCmdReqDTO);
    }
}
