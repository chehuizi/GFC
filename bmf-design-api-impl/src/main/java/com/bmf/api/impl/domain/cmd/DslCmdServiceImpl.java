package com.bmf.api.impl.domain.cmd;

import com.bmf.api.Result;
import com.bmf.api.domain.cmd.DslCmdService;
import com.bmf.api.domain.dto.DslCmdReqDTO;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.ResultUtil;
import com.bmf.core.domain.DslService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DslCmdServiceImpl implements DslCmdService {

    @Autowired
    private DslService dslService;

    @Override
    public Result<Boolean> addDslExt(DslCmdReqDTO dslCmdReqDTO) {
        return ResultUtil.success(dslService.addDslExt(dslCmdReqDTO.getDslExtList()));
    }

    @Override
    public Result<Boolean> delDslExt(DslCmdReqDTO dslCmdReqDTO) {
        return ResultUtil.success(dslService.delDslExt(dslCmdReqDTO.getDslExt()));
    }

    @Override
    public Result<Boolean> create(DslCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> update(DslCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(DslCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }
}
