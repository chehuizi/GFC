package com.bmf.design.api.validator;

import com.bmf.design.api.business.dto.BusinessQryReqDTO;
import com.bmf.design.common.utils.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("businessQryReqDTOValidator")
public class BusinessQryReqDTOValidator {

    /**
     * 校验queryOne方法
     * @param businessQryReqDTO
     * @return
     */
    public boolean v4QueryOne(BusinessQryReqDTO businessQryReqDTO) {
        ParamCheckUtil.checkNull(businessQryReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessQryReqDTO.getBusiness(), "business is null");
        ParamCheckUtil.checkNull(businessQryReqDTO.getBusiness().getBusinessCode(), "business code is null");
        return true;
    }
}
