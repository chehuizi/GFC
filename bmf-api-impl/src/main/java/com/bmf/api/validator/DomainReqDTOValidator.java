package com.bmf.api.validator;

import com.bmf.api.domain.DomainReqDTO;
import com.bmf.common.utils.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("domainReqDTOValidator")
public class DomainReqDTOValidator {

    /**
     * 校验create方法
     * @param domainReqDTO
     * @return
     */
    public boolean v4Create(DomainReqDTO domainReqDTO) {
        ParamCheckUtil.checkNull(domainReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainReqDTO.getBusinessDomain(), "domain is null");
        return true;
    }

}
