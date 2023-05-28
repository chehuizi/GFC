package com.bmf.api.validator;

import com.bmf.api.user.dto.UserBusinessQryReqDTO;
import com.bmf.common.utils.ParamCheckUtil;
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
