package com.bmf.api.impl.domain.cmd;

import com.bmf.api.Result;
import com.bmf.api.domain.cmd.DomainServiceCmdService;
import com.bmf.api.domain.dto.DomainServiceCmdReqDTO;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.domain.DomainServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainServiceCmdServiceImpl implements DomainServiceCmdService {

    @Autowired
    private DomainServiceService domainServiceService;

    @Override
    @Validator(beanName = "domainServiceReqDTOValidator", method = "v4AddServiceAttr")
    public Result<Boolean> addServiceAttr(DomainServiceCmdReqDTO domainServiceCmdReqDTO) {
        return ResultUtil.success(domainServiceService.addServiceAttr(domainServiceCmdReqDTO.getServiceAttr()));
    }

    @Override
    @Validator(beanName = "domainServiceReqDTOValidator", method = "v4DelServiceAttr")
    public Result<Boolean> delServiceAttr(DomainServiceCmdReqDTO domainServiceCmdReqDTO) {
        return ResultUtil.success(domainServiceService.delServiceAttr(domainServiceCmdReqDTO.getServiceAttr()));
    }

    @Override
    public Result<Boolean> create(DomainServiceCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> update(DomainServiceCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(DomainServiceCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }
}
