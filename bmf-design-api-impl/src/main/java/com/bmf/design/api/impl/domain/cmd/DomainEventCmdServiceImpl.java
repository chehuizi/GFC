package com.bmf.design.api.impl.domain.cmd;

import com.bmf.design.api.Result;
import com.bmf.design.api.domain.cmd.DomainEventCmdService;
import com.bmf.design.api.domain.dto.DomainEventCmdReqDTO;
import com.bmf.design.common.utils.ResultUtil;
import com.bmf.design.common.validator.Validator;
import com.bmf.design.core.domain.DomainEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainEventCmdServiceImpl implements DomainEventCmdService {

    @Autowired
    private DomainEventService domainEventService;

    @Override
    @Validator(beanName = "domainEventReqDTOValidator", method = "v4AddEventAttr")
    public Result<Boolean> addEventAttr(DomainEventCmdReqDTO domainEventCmdReqDTO) {
        return ResultUtil.success(domainEventService.addEventAttr(domainEventCmdReqDTO.getEventAttr()));
    }

    @Override
    @Validator(beanName = "domainEventReqDTOValidator", method = "v4DelEventAttr")
    public Result<Boolean> delEventAttr(DomainEventCmdReqDTO domainEventCmdReqDTO) {
        return ResultUtil.success(domainEventService.delEventAttr(domainEventCmdReqDTO.getEventAttr()));
    }

    @Override
    public Result<Boolean> create(DomainEventCmdReqDTO req) {
        return null;
    }

    @Override
    public Result<Boolean> update(DomainEventCmdReqDTO req) {
        return null;
    }

    @Override
    public Result<Boolean> delete(DomainEventCmdReqDTO req) {
        return null;
    }

}
