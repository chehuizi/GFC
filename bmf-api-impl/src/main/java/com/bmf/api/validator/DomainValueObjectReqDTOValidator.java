package com.bmf.api.validator;

import com.bmf.api.domain.dto.DomainValueObjectReqDTO;
import com.bmf.common.utils.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("domainValueObjectReqDTOValidator")
public class DomainValueObjectReqDTOValidator {

    /**
     * 校验addValueObjectAttr方法
     * @param domainValueObjectReqDTO
     * @return
     */
    public boolean v4AddValueObjectAttr(DomainValueObjectReqDTO domainValueObjectReqDTO) {
        ParamCheckUtil.checkNull(domainValueObjectReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainValueObjectReqDTO.getDomainValueObject(), "domain value object is null");
        ParamCheckUtil.checkNull(domainValueObjectReqDTO.getDomainValueObject().getVoCode(), "domain value object code is null");
        ParamCheckUtil.checkNull(domainValueObjectReqDTO.getValueObjectAttr(), "value object attr is null");
        ParamCheckUtil.checkBlank(domainValueObjectReqDTO.getValueObjectAttr().getAttrName(), "value object attr name is blank");
        ParamCheckUtil.checkBlank(domainValueObjectReqDTO.getValueObjectAttr().getAttrType(), "value object attr type is blank");
        ParamCheckUtil.checkBlank(domainValueObjectReqDTO.getValueObjectAttr().getAttrDesc(), "value object attr desc is blank");
        return true;
    }

    /**
     * 校验delValueObjectAttr方法
     * @param domainValueObjectReqDTO
     * @return
     */
    public boolean v4DelValueObjectAttr(DomainValueObjectReqDTO domainValueObjectReqDTO) {
        ParamCheckUtil.checkNull(domainValueObjectReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainValueObjectReqDTO.getValueObjectAttr(), "value object attr is null");
        ParamCheckUtil.checkNull(domainValueObjectReqDTO.getValueObjectAttr().getVoCode(), "value object code is null");
        ParamCheckUtil.checkBlank(domainValueObjectReqDTO.getValueObjectAttr().getAttrName(), "value object attr name is blank");
        return true;
    }
}


