package com.bmf.api.impl.domain.qry;

import com.bmf.api.Result;
import com.bmf.api.domain.dto.DomainEventQryReqDTO;
import com.bmf.api.domain.dto.DomainEventRespDTO;
import com.bmf.api.domain.qry.DomainEventQryService;
import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.domain.DomainEventService;
import com.bmf.core.domain.DomainService;
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
        BusinessDomain domain = domainService.queryDomain(new BusinessDomain(req.getDomainEvent().getDomainCode()));
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
