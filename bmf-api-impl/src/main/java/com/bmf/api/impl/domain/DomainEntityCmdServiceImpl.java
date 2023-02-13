package com.bmf.api.impl.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.DomainEntityCmdService;
import com.bmf.api.domain.dto.DomainEntityReqDTO;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.domain.DomainEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainEntityCmdServiceImpl implements DomainEntityCmdService {

    @Autowired
    private DomainEntityService domainEntityService;

    @Override
    @Validator(beanName = "domainEntityReqDTOValidator", method = "v4AddEntityAttr")
    public Result<Boolean> addEntityAttr(DomainEntityReqDTO domainEntityReqDTO) {
        DomainEntity domainEntity = domainEntityService.queryDomainEntity(domainEntityReqDTO.getDomainEntity());
        BusinessCheckUtil.checkNull(domainEntity, BizCodeEnum.DOMAIN_ENTITY_NOT_EXIST);
        domainEntityReqDTO.getEntityAttr().setEntityIdCode(domainEntity.getEntityIdCode());
        return ResultUtil.success(domainEntityService.addEntityAttr(domainEntityReqDTO.getEntityAttr()));
    }

    @Override
    @Validator(beanName = "domainEntityReqDTOValidator", method = "v4DelEntityAttr")
    public Result<Boolean> delEntityAttr(DomainEntityReqDTO domainEntityReqDTO) {
        DomainEntity domainEntity = domainEntityService.queryDomainEntity(domainEntityReqDTO.getDomainEntity());
        BusinessCheckUtil.checkNull(domainEntity, BizCodeEnum.DOMAIN_ENTITY_NOT_EXIST);
        return ResultUtil.success(domainEntityService.delEntityAttr(domainEntityReqDTO.getEntityAttr()));
    }

    @Override
    public Result<Boolean> create(DomainEntityReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> update(DomainEntityReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(DomainEntityReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }
}
