package com.bmf.design.api.impl.domain.qry;

import com.bmf.common.api.Result;
import com.bmf.common.api.validator.Validator;
import com.bmf.common.utils.checker.BusinessCheckUtil;
import com.bmf.design.api.domain.dto.DomainEventQryReqDTO;
import com.bmf.design.api.domain.dto.DomainEventRespDTO;
import com.bmf.design.api.domain.qry.DomainEventQryService;
import com.bmf.design.model.Domain;
import com.bmf.design.model.tactics.event.DomainEvent;
import com.bmf.common.api.enums.BizCodeEnum;
import com.bmf.common.api.utils.ResultUtil;
import com.bmf.design.core.domain.DomainEventService;
import com.bmf.design.core.domain.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainEventQryServiceImpl implements DomainEventQryService {

    @Autowired
    private DomainService domainService;
    @Autowired
    private DomainEventService domainEventService;

    @Override
    @Validator(beanName = "domainEventReqDTOValidator", method = "v4QueryOne")
    public Result<DomainEventRespDTO> queryOne(DomainEventQryReqDTO req) {
        Domain domain = domainService.queryDomain(new Domain(req.getDomainEvent().getDomainCode()));
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        DomainEvent domainEvent = domainEventService.queryDomainEvent(req.getDomainEvent());
        BusinessCheckUtil.checkNull(domainEvent, BizCodeEnum.DOMAIN_EVENT_NOT_EXIST);
        DomainEventRespDTO domainEventRespDTO = new DomainEventRespDTO();
        domainEventRespDTO.setDomainEvent(domainEvent);
        if (req.isIncludeAttr()) {
            domainEventRespDTO.setEventAttrList(domainEventService.queryEventAttr(domainEvent.getEventCode()));
        }
        return ResultUtil.success(domainEventRespDTO);
    }

}
