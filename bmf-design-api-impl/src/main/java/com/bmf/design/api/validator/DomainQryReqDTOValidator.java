package com.bmf.design.api.validator;

import com.bmf.design.api.domain.dto.DomainQryReqDTO;
import com.bmf.design.common.utils.ParamCheckUtil;
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
        ParamCheckUtil.checkNull(domainQryReqDTO.getDomain(), "domain is null");
        ParamCheckUtil.checkTrue(Objects.nonNull(domainQryReqDTO.getDomain().getDomainCode()) ||
                        StringUtils.isNotBlank(domainQryReqDTO.getDomain().getDomainAlias()),
                "domain code is null && domain alias is blank");
        return true;
    }
}
