package com.bmf.api.validator;

import com.bmf.api.domain.dto.DomainServiceReqDTO;
import com.bmf.common.utils.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("domainServiceReqDTOValidator")
public class DomainServiceReqDTOValidator {

    /**
     * 校验addServiceAttr方法
     * @param domainServiceReqDTO
     * @return
     */
    public boolean v4AddServiceAttr(DomainServiceReqDTO domainServiceReqDTO) {
        ParamCheckUtil.checkNull(domainServiceReqDTO, "param is null");
        return true;
    }

    /**
     * 校验delServiceAttr方法
     * @param domainServiceReqDTO
     * @return
     */
    public boolean v4DelServiceAttr(DomainServiceReqDTO domainServiceReqDTO) {
        ParamCheckUtil.checkNull(domainServiceReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainServiceReqDTO.getServiceAttr(), "service attr is null");
        ParamCheckUtil.checkNull(domainServiceReqDTO.getServiceAttr().getServiceCode(), "service code is null");
        ParamCheckUtil.checkBlank(domainServiceReqDTO.getServiceAttr().getAttrName(), "service attr name is blank");
        return true;
    }
}


