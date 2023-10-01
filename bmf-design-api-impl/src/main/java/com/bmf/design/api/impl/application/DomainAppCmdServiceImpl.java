package com.bmf.design.api.impl.application;

import com.bmf.design.api.Result;
import com.bmf.design.api.application.DomainAppCmdService;
import com.bmf.design.api.application.dto.DomainAppCmdReqDTO;
import com.bmf.design.common.enums.BizCodeEnum;
import com.bmf.design.common.utils.ResultUtil;
import com.bmf.design.common.validator.Validator;
import com.bmf.design.core.application.DomainAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainAppCmdServiceImpl implements DomainAppCmdService {

    @Autowired
    private DomainAppService domainAppService;

    @Override
    @Validator(beanName = "domainApiCmdReqDTOValidator", method = "v4Create")
    public Result<Boolean> create(DomainAppCmdReqDTO req) {
        return ResultUtil.success(domainAppService.createApi(req));
    }

    @Override
    public Result<Boolean> update(DomainAppCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(DomainAppCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }
}
