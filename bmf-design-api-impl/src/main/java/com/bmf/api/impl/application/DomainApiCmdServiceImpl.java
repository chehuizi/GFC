package com.bmf.api.impl.application;

import com.bmf.api.Result;
import com.bmf.api.application.DomainApiCmdService;
import com.bmf.api.application.dto.DomainApiCmdReqDTO;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.application.DomainApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainApiCmdServiceImpl implements DomainApiCmdService {

    @Autowired
    private DomainApiService domainApiService;

    @Override
    @Validator(beanName = "domainApiCmdReqDTOValidator", method = "v4Create")
    public Result<Boolean> create(DomainApiCmdReqDTO req) {
        return ResultUtil.success(domainApiService.createApi(req));
    }

    @Override
    public Result<Boolean> update(DomainApiCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(DomainApiCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }
}
