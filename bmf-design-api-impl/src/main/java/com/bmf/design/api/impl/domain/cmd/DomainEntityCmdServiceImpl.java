package com.bmf.design.api.impl.domain.cmd;

import com.bmf.common.api.Result;
import com.bmf.common.api.validator.Validator;
import com.bmf.common.utils.checker.BusinessCheckUtil;
import com.bmf.design.api.domain.cmd.DomainEntityCmdService;
import com.bmf.design.api.domain.dto.DomainEntityCmdReqDTO;
import com.bmf.design.model.tactics.entity.DomainEntity;
import com.bmf.common.api.enums.BizCodeEnum;
import com.bmf.common.api.utils.ResultUtil;
import com.bmf.design.core.domain.DomainEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainEntityCmdServiceImpl implements DomainEntityCmdService {

    @Autowired
    private DomainEntityService domainEntityService;

    @Override
    @Validator(beanName = "domainEntityReqDTOValidator", method = "v4AddEntityAttr")
    public Result<Boolean> addEntityAttr(DomainEntityCmdReqDTO domainEntityCmdReqDTO) {
        DomainEntity domainEntity = domainEntityService.queryDomainEntity(domainEntityCmdReqDTO.getDomainEntity());
        BusinessCheckUtil.checkNull(domainEntity, BizCodeEnum.DOMAIN_ENTITY_NOT_EXIST);
        domainEntityCmdReqDTO.getEntityAttr().setEntityIdCode(domainEntity.getEntityIdCode());
        return ResultUtil.success(domainEntityService.addEntityAttr(domainEntityCmdReqDTO.getEntityAttr()));
    }

    @Override
    @Validator(beanName = "domainEntityReqDTOValidator", method = "v4DelEntityAttr")
    public Result<Boolean> delEntityAttr(DomainEntityCmdReqDTO domainEntityCmdReqDTO) {
        DomainEntity domainEntity = domainEntityService.queryDomainEntity(domainEntityCmdReqDTO.getDomainEntity());
        BusinessCheckUtil.checkNull(domainEntity, BizCodeEnum.DOMAIN_ENTITY_NOT_EXIST);
        return ResultUtil.success(domainEntityService.delEntityAttr(domainEntityCmdReqDTO.getEntityAttr()));
    }

    @Override
    public Result<Boolean> create(DomainEntityCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> update(DomainEntityCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(DomainEntityCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }
}
