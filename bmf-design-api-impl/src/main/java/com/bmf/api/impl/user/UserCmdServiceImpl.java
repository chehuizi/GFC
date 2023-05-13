package com.bmf.api.impl.user;

import com.bmf.api.Result;
import com.bmf.api.user.UserCmdService;
import com.bmf.api.user.dto.UserCmdReqDTO;
import com.bmf.base.enums.CodeKeyEnum;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.ResultUtil;
import com.bmf.core.user.UserService;
import com.bmf.infrastructure.generator.CodeSeqGenerator;
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
