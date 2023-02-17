package com.bmf.api.impl.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.DomainServiceCmdService;
import com.bmf.api.domain.dto.DomainServiceReqDTO;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.ResultUtil;
import com.bmf.core.domain.DomainServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainServiceCmdServiceImpl implements DomainServiceCmdService {

    @Autowired
    private DomainServiceService domainServiceService;

    @Override
    public Result<Boolean> addServiceAttr(DomainServiceReqDTO domainServiceReqDTO) {
        return ResultUtil.success(domainServiceService.addServiceAttr(domainServiceReqDTO.getServiceAttr()));
    }

    @Override
    public Result<Boolean> delServiceAttr(DomainServiceReqDTO domainServiceReqDTO) {
        return null;
    }

    @Override
    public Result<Boolean> create(DomainServiceReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> update(DomainServiceReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(DomainServiceReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }
}
