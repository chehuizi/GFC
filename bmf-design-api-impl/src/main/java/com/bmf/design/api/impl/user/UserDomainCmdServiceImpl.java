package com.bmf.design.api.impl.user;

import com.bmf.design.api.Result;
import com.bmf.design.api.user.UserDomainCmdService;
import com.bmf.design.api.user.dto.UserDomainCmdReqDTO;
import com.bmf.design.common.enums.BizCodeEnum;
import com.bmf.design.common.utils.ResultUtil;
import com.bmf.design.core.user.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDomainCmdServiceImpl implements UserDomainCmdService {

    @Autowired
    private UserDomainService userDomainService;

    @Override
    public Result<Boolean> create(UserDomainCmdReqDTO req) {
        return ResultUtil.success(userDomainService.addUserDomain(req.getUserDomain()));
    }

    @Override
    public Result<Boolean> update(UserDomainCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(UserDomainCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }
}
