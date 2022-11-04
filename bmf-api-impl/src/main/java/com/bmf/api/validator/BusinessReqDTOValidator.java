package com.bmf.api.validator;

import com.bmf.api.business.BusinessReqDTO;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.exception.BizException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("businessReqDTOValidator")
public class BusinessReqDTOValidator {

    /**
     * 校验create方法
     * @param businessReqDTO
     * @return
     */
    public boolean v4Create(BusinessReqDTO businessReqDTO) {
        if (Objects.isNull(businessReqDTO)) {
            throw new BizException(BizCodeEnum.PARAM_ERROR);
        } else if (Objects.isNull(businessReqDTO.getBusiness())) {
            throw new BizException(BizCodeEnum.PARAM_ERROR, "business is null");
        }
        return true;
    }

    /**
     * 校验addDomain方法
     * @param businessReqDTO
     * @return
     */
    public boolean v4AddDomain(BusinessReqDTO businessReqDTO) {
        if (Objects.isNull(businessReqDTO)) {
            throw new BizException(BizCodeEnum.PARAM_ERROR);
        }
        return true;
    }
}
