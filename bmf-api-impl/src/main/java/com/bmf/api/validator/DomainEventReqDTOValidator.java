package com.bmf.api.validator;

import com.bmf.api.domain.dto.DomainEventQryReqDTO;
import com.bmf.api.domain.dto.DomainEventReqDTO;
import com.bmf.common.utils.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("domainEventReqDTOValidator")
public class DomainEventReqDTOValidator {

    /**
     * 校验queryOne方法
     * @param domainEventQryReqDTO
     * @return
     */
    public boolean v4QueryOne(DomainEventQryReqDTO domainEventQryReqDTO) {
        ParamCheckUtil.checkNull(domainEventQryReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainEventQryReqDTO.getDomainEvent(), "domain event is null");
        ParamCheckUtil.checkNull(domainEventQryReqDTO.getDomainEvent().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainEventQryReqDTO.getDomainEvent().getEventCode(), "event code is null");
        return true;
    }

    /**
     * 校验addEventAttr方法
     * @param domainEventReqDTO
     * @return
     */
    public boolean v4AddEventAttr(DomainEventReqDTO domainEventReqDTO) {
        ParamCheckUtil.checkNull(domainEventReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainEventReqDTO.getDomainEvent(), "domain event is null");
        ParamCheckUtil.checkNull(domainEventReqDTO.getDomainEvent().getEventCode(), "event code is null");
        ParamCheckUtil.checkNull(domainEventReqDTO.getEventAttr(), "event attr is null");
        ParamCheckUtil.checkBlank(domainEventReqDTO.getEventAttr().getAttrName(), "event attr name is blank");
        ParamCheckUtil.checkBlank(domainEventReqDTO.getEventAttr().getAttrType(), "event attr type is blank");
        ParamCheckUtil.checkBlank(domainEventReqDTO.getEventAttr().getAttrDesc(), "event attr desc is blank");
        return true;
    }

    /**
     * 校验delEventAttr方法
     * @param domainEventReqDTO
     * @return
     */
    public boolean v4DelEventAttr(DomainEventReqDTO domainEventReqDTO) {
        ParamCheckUtil.checkNull(domainEventReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainEventReqDTO.getEventAttr(), "event attr is null");
        ParamCheckUtil.checkNull(domainEventReqDTO.getEventAttr().getEventCode(), "event code is null");
        ParamCheckUtil.checkBlank(domainEventReqDTO.getEventAttr().getAttrName(), "event attr name is blank");
        return true;
    }

}
