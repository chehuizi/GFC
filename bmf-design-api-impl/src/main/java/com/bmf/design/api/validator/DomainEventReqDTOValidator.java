package com.bmf.design.api.validator;

import com.bmf.design.api.domain.dto.DomainEventQryReqDTO;
import com.bmf.design.api.domain.dto.DomainEventCmdReqDTO;
import com.bmf.common.utils.checker.ParamCheckUtil;
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
     * @param domainEventCmdReqDTO
     * @return
     */
    public boolean v4AddEventAttr(DomainEventCmdReqDTO domainEventCmdReqDTO) {
        ParamCheckUtil.checkNull(domainEventCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainEventCmdReqDTO.getDomainEvent(), "domain event is null");
        ParamCheckUtil.checkNull(domainEventCmdReqDTO.getDomainEvent().getEventCode(), "event code is null");
        ParamCheckUtil.checkNull(domainEventCmdReqDTO.getEventAttr(), "event attr is null");
        ParamCheckUtil.checkBlank(domainEventCmdReqDTO.getEventAttr().getAttrName(), "event attr name is blank");
        ParamCheckUtil.checkBlank(domainEventCmdReqDTO.getEventAttr().getAttrType(), "event attr type is blank");
        ParamCheckUtil.checkBlank(domainEventCmdReqDTO.getEventAttr().getAttrDesc(), "event attr desc is blank");
        return true;
    }

    /**
     * 校验delEventAttr方法
     * @param domainEventCmdReqDTO
     * @return
     */
    public boolean v4DelEventAttr(DomainEventCmdReqDTO domainEventCmdReqDTO) {
        ParamCheckUtil.checkNull(domainEventCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainEventCmdReqDTO.getEventAttr(), "event attr is null");
        ParamCheckUtil.checkNull(domainEventCmdReqDTO.getEventAttr().getEventCode(), "event code is null");
        ParamCheckUtil.checkBlank(domainEventCmdReqDTO.getEventAttr().getAttrName(), "event attr name is blank");
        return true;
    }

}
