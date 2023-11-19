package com.bmf.design.api.impl.domain.cmd;

import com.bmf.common.api.Result;
import com.bmf.design.api.domain.cmd.DslCmdService;
import com.bmf.design.api.domain.dto.DslCmdReqDTO;
import com.bmf.common.api.enums.BizCodeEnum;
import com.bmf.common.api.utils.ResultUtil;
import com.bmf.design.core.domain.DslService;
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
