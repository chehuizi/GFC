package com.bmf.design.api.impl.user;

import com.bmf.design.api.Result;
import com.bmf.design.api.user.UserCmdService;
import com.bmf.design.api.user.dto.UserCmdReqDTO;
import com.bmf.design.base.enums.CodeKeyEnum;
import com.bmf.design.common.enums.BizCodeEnum;
import com.bmf.design.common.utils.ResultUtil;
import com.bmf.design.core.user.UserService;
import com.bmf.design.infrastructure.generator.CodeSeqGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCmdServiceImpl implements UserCmdService {

    @Autowired
    private UserService userService;
    @Autowired
    private CodeSeqGenerator codeSeqGenerator;

    @Override
    public Result<Boolean> create(UserCmdReqDTO req) {
        req.getUser().setUserId(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_USER.getKey()));
        return ResultUtil.success(userService.addUser(req.getUser()));
    }

    @Override
    public Result<Boolean> update(UserCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(UserCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

}
