package com.bmf.api.validator;

import com.bmf.api.application.dto.BusinessApiCmdReqDTO;
import com.bmf.common.utils.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("businessApiCmdReqDTOValidator")
public class BusinessApiCmdReqDTOValidator {

    /**
     * 校验create方法
     * @param businessApiCmdReqDTO
     * @return
     */
    public boolean v4Create(BusinessApiCmdReqDTO businessApiCmdReqDTO) {
        ParamCheckUtil.checkNull(businessApiCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessApiCmdReqDTO.getBusinessApiList(), "business api list is null");
        return true;
    }
}
