package com.bmf.api.impl.application;

import com.bmf.api.Result;
import com.bmf.api.application.DomainAppCmdService;
import com.bmf.api.application.dto.DomainAppCmdReqDTO;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.application.DomainAppService;
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
