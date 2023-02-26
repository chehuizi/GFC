package com.bmf.api.validator;

import com.bmf.api.domain.dto.DomainQryReqDTO;
import com.bmf.common.utils.ParamCheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("domainQryReqDTOValidator")
public class DomainQryReqDTOValidator {

    /**
     * 校验queryOne方法
     * @param domainQryReqDTO
     * @return
     */
    public boolean v4QueryOne(DomainQryReqDTO domainQryReqDTO) {
        ParamCheckUtil.checkNull(domainQryReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainQryReqDTO.getBusinessDomain(), "domain is null");
        ParamCheckUtil.checkTrue(Objects.nonNull(domainQryReqDTO.getBusinessDomain().getDomainCode()) ||
                        StringUtils.isNotBlank(domainQryReqDTO.getBusinessDomain().getDomainAlias()),
                "domain code is null && domain alias is blank");
        return true;
    }
}
