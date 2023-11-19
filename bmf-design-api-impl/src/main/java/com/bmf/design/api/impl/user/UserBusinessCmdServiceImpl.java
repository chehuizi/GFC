package com.bmf.design.api.impl.user;

import com.bmf.common.api.Result;
import com.bmf.design.api.user.UserBusinessCmdService;
import com.bmf.design.api.user.dto.UserBusinessCmdReqDTO;
import com.bmf.common.api.enums.BizCodeEnum;
import com.bmf.common.api.utils.ResultUtil;
import com.bmf.design.core.user.UserBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessCmdServiceImpl implements UserBusinessCmdService {

    @Autowired
    private UserBusinessService userBusinessService;

    @Override
    public Result<Boolean> create(UserBusinessCmdReqDTO req) {
        return ResultUtil.success(userBusinessService.addUserBusiness(req.getUserBusiness()));
    }

    @Override
    public Result<Boolean> update(UserBusinessCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(UserBusinessCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }
}
