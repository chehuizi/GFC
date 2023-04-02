package com.bmf.api.impl.application;

import com.bmf.api.Result;
import com.bmf.api.application.BusinessApiCmdService;
import com.bmf.api.application.dto.BusinessApiCmdReqDTO;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.application.BusinessApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessApiCmdServiceImpl implements BusinessApiCmdService {

    @Autowired
    private BusinessApiService businessApiService;

    @Override
    @Validator(beanName = "businessApiCmdReqDTOValidator", method = "v4Create")
    public Result<Boolean> create(BusinessApiCmdReqDTO req) {
        return ResultUtil.success(businessApiService.createBusinessApi(req.getBusinessApiList()));
    }

    @Override
    public Result<Boolean> update(BusinessApiCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(BusinessApiCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }
}
