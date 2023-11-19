package com.bmf.design.api.impl.domain.cmd;

import com.bmf.common.api.Result;
import com.bmf.design.api.domain.cmd.DomainValueObjectCmdService;
import com.bmf.design.api.domain.dto.DomainValueObjectReqDTO;
import com.bmf.common.api.enums.BizCodeEnum;
import com.bmf.common.api.utils.ResultUtil;
import com.bmf.common.api.validator.Validator;
import com.bmf.design.core.domain.DomainValueObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainValueObjectCmdServiceImpl implements DomainValueObjectCmdService {

    @Autowired
    private DomainValueObjectService domainValueObjectService;

    @Override
    @Validator(beanName = "domainValueObjectReqDTOValidator", method = "v4AddValueObjectAttr")
    public Result<Boolean> addValueObjectAttr(DomainValueObjectReqDTO domainValueObjectReqDTO) {
        return ResultUtil.success(domainValueObjectService.addValueObjectAttr(domainValueObjectReqDTO.getValueObjectAttr()));
    }

    @Override
    @Validator(beanName = "domainValueObjectReqDTOValidator", method = "v4DelValueObjectAttr")
    public Result<Boolean> delValueObjectAttr(DomainValueObjectReqDTO domainValueObjectReqDTO) {
        return ResultUtil.success(domainValueObjectService.delValueObjectAttr(domainValueObjectReqDTO.getValueObjectAttr()));
    }

    @Override
    public Result<Boolean> create(DomainValueObjectReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> update(DomainValueObjectReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(DomainValueObjectReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }
}
