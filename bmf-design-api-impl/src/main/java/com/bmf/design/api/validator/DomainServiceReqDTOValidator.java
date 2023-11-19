package com.bmf.design.api.validator;

import com.bmf.design.api.domain.dto.DomainServiceQryReqDTO;
import com.bmf.design.api.domain.dto.DomainServiceCmdReqDTO;
import com.bmf.common.utils.checker.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("domainServiceReqDTOValidator")
public class DomainServiceReqDTOValidator {

    /**
     * 校验queryOne方法
     * @param domainServiceQryReqDTO
     * @return
     */
    public boolean v4QueryOne(DomainServiceQryReqDTO domainServiceQryReqDTO) {
        ParamCheckUtil.checkNull(domainServiceQryReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainServiceQryReqDTO.getDomainService(), "domain service is null");
        ParamCheckUtil.checkNull(domainServiceQryReqDTO.getDomainService().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainServiceQryReqDTO.getDomainService().getServiceCode(), "service code is null");
        return true;
    }

    /**
     * 校验addServiceAttr方法
     * @param domainServiceCmdReqDTO
     * @return
     */
    public boolean v4AddServiceAttr(DomainServiceCmdReqDTO domainServiceCmdReqDTO) {
        ParamCheckUtil.checkNull(domainServiceCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainServiceCmdReqDTO.getDomainService(), "domain service is null");
        ParamCheckUtil.checkNull(domainServiceCmdReqDTO.getDomainService().getServiceCode(), "service code is null");
        ParamCheckUtil.checkNull(domainServiceCmdReqDTO.getServiceAttr(), "service attr is null");
        ParamCheckUtil.checkBlank(domainServiceCmdReqDTO.getServiceAttr().getAttrName(), "service attr name is blank");
        ParamCheckUtil.checkBlank(domainServiceCmdReqDTO.getServiceAttr().getAttrType(), "service attr type is blank");
        ParamCheckUtil.checkBlank(domainServiceCmdReqDTO.getServiceAttr().getAttrDesc(), "service attr desc is blank");
        return true;
    }

    /**
     * 校验delServiceAttr方法
     * @param domainServiceCmdReqDTO
     * @return
     */
    public boolean v4DelServiceAttr(DomainServiceCmdReqDTO domainServiceCmdReqDTO) {
        ParamCheckUtil.checkNull(domainServiceCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainServiceCmdReqDTO.getServiceAttr(), "service attr is null");
        ParamCheckUtil.checkNull(domainServiceCmdReqDTO.getServiceAttr().getServiceCode(), "service code is null");
        ParamCheckUtil.checkBlank(domainServiceCmdReqDTO.getServiceAttr().getAttrName(), "service attr name is blank");
        return true;
    }
}


