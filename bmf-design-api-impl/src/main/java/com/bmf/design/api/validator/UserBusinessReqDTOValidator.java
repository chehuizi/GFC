package com.bmf.design.api.validator;

import com.bmf.design.api.user.dto.UserBusinessQryReqDTO;
import com.bmf.design.common.utils.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("userBusinessReqDTOValidator")
public class UserBusinessReqDTOValidator {

    /**
     * 校验queryOne方法
     * @param userBusinessQryReqDTO
     * @return
     */
    public boolean v4QueryOne(UserBusinessQryReqDTO userBusinessQryReqDTO) {
        ParamCheckUtil.checkNull(userBusinessQryReqDTO, "param is null");
        ParamCheckUtil.checkNull(userBusinessQryReqDTO.getUserBusiness(), "user business is null");
        ParamCheckUtil.checkNull(userBusinessQryReqDTO.getUserBusiness().getUserId(),
                "user id is null");
        return true;
    }
}
