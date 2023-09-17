package com.bmf.api.validator;

import com.bmf.api.application.dto.DomainApiCmdReqDTO;
import com.bmf.common.utils.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("domainApiCmdReqDTOValidator")
public class DomainApiCmdReqDTOValidator {

    /**
     * 校验create方法
     * @param domainApiCmdReqDTO
     * @return
     */
    public boolean v4Create(DomainApiCmdReqDTO domainApiCmdReqDTO) {
        ParamCheckUtil.checkNull(domainApiCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainApiCmdReqDTO.getDomainApiList(), "business api list is null");
        return true;
    }
}
