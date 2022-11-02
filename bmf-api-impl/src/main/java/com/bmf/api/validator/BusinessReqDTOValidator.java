package com.bmf.api.validator;

import com.bmf.api.business.BusinessReqDTO;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.exception.BizException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("businessReqDTOValidator")
public class BusinessReqDTOValidator {

    public boolean v4Create(BusinessReqDTO businessReqDTO) {
        if (Objects.isNull(businessReqDTO) || Objects.isNull(businessReqDTO.getBusiness())) {
            throw new BizException(BizCodeEnum.PARAM_ERROR);
        }
        return true;
    }
}
