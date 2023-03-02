package com.bmf.api.impl.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.cmd.DomainCmdService;
import com.bmf.api.domain.dto.DomainCmdReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.CodeKeyEnum;
import com.bmf.base.tactics.entity.EntityRelVO;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.valueobject.DomainValueObject;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.design.BusinessDomainDesign4Tactics;
import com.bmf.core.domain.DomainEntityService;
import com.bmf.core.domain.DomainService;
import com.bmf.core.domain.DomainValueObjectService;
import com.bmf.infrastructure.generator.CodeSeqGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainCmdServiceImpl implements DomainCmdService {

    @Autowired
    private DomainService domainService;
    @Autowired
    private DomainEntityService domainEntityService;
    @Autowired
    private DomainValueObjectService domainValueObjectService;
    @Autowired
    private BusinessDomainDesign4Tactics businessDomainDesign4Tactics;
    @Autowired
    private CodeSeqGenerator codeSeqGenerator;

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4Create")
    public Result<Boolean> create(DomainCmdReqDTO req) {
        BusinessDomain domain = req.getBusinessDomain();
        BusinessDomain queryResult = domainService.queryDomain(domain);
        BusinessCheckUtil.checkNonNull(queryResult, BizCodeEnum.DOMAIN_IS_EXISTED);
        domain.setDomainCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_DOMAIN.getKey()));
        return ResultUtil.success(domainService.createDomain(domain));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4Update")
    public Result<Boolean> update(DomainCmdReqDTO req) {
        BusinessDomain domain = req.getBusinessDomain();
        BusinessDomain queryResult = domainService.queryDomain(domain);
        BusinessCheckUtil.checkNull(queryResult, BizCodeEnum.DOMAIN_NOT_EXIST);
        return ResultUtil.success(domainService.updateDomain(domain));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4Delete")
    public Result<Boolean> delete(DomainCmdReqDTO req) {
        BusinessDomain domain = req.getBusinessDomain();
        return ResultUtil.success(domainService.deleteDomain(domain));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4AddEntity")
    public Result<Boolean> addEntity(DomainCmdReqDTO domainCmdReqDTO) {
        BusinessDomain domain = domainService.queryDomain(domainCmdReqDTO.getBusinessDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        DomainEntity domainEntity = domainEntityService.queryDomainEntity(domainCmdReqDTO.getDomainEntity());
        BusinessCheckUtil.checkNonNull(domainEntity, BizCodeEnum.DOMAIN_ENTITY_IS_EXISTED);
        domainCmdReqDTO.getDomainEntity().setEntityIdCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_ENTITY.getKey()));
        return ResultUtil.success(businessDomainDesign4Tactics.addEntity(domainCmdReqDTO.getBusinessDomain(), domainCmdReqDTO.getDomainEntity()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4DelEntity")
    public Result<Boolean> delEntity(DomainCmdReqDTO domainCmdReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.delEntity(domainCmdReqDTO.getDomainEntity()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4AddService")
    public Result<Boolean> addService(DomainCmdReqDTO domainCmdReqDTO) {
        BusinessDomain domain = domainService.queryDomain(domainCmdReqDTO.getBusinessDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        domainCmdReqDTO.getDomainService().setServiceCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_SERVICE.getKey()));
        return ResultUtil.success(businessDomainDesign4Tactics.addService(domainCmdReqDTO.getBusinessDomain(), domainCmdReqDTO.getDomainService()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4DelService")
    public Result<Boolean> delService(DomainCmdReqDTO domainCmdReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.delService(domainCmdReqDTO.getDomainService()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4AddValueObject")
    public Result<Boolean> addValueObject(DomainCmdReqDTO domainCmdReqDTO) {
        BusinessDomain domain = domainService.queryDomain(domainCmdReqDTO.getBusinessDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        domainCmdReqDTO.getDomainValueObject().setVoCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_VALUE_OBJECT.getKey()));
        return ResultUtil.success(businessDomainDesign4Tactics.addValueObject(domainCmdReqDTO.getBusinessDomain(), domainCmdReqDTO.getDomainValueObject()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4DelValueObject")
    public Result<Boolean> delValueObject(DomainCmdReqDTO domainCmdReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.delValueObject(domainCmdReqDTO.getDomainValueObject()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4AddDomainEvent")
    public Result<Boolean> addDomainEvent(DomainCmdReqDTO domainCmdReqDTO) {
        BusinessDomain domain = domainService.queryDomain(domainCmdReqDTO.getBusinessDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        domainCmdReqDTO.getDomainEvent().setEventCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_EVENT.getKey()));
        return ResultUtil.success(businessDomainDesign4Tactics.addDomainEvent(domainCmdReqDTO.getBusinessDomain(), domainCmdReqDTO.getDomainEvent()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4DelDomainEvent")
    public Result<Boolean> delDomainEvent(DomainCmdReqDTO domainCmdReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.delDomainEvent(domainCmdReqDTO.getDomainEvent()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4AddEntityRelVO")
    public Result<Boolean> addEntityRelVO(DomainCmdReqDTO domainCmdReqDTO) {
        DomainEntity domainEntity = domainEntityService.queryDomainEntity(domainCmdReqDTO.getDomainEntity());
        BusinessCheckUtil.checkNull(domainEntity, BizCodeEnum.DOMAIN_ENTITY_NOT_EXIST);
        DomainValueObject domainValueObject = domainValueObjectService.queryDomainValueObject(domainCmdReqDTO.getDomainValueObject());
        BusinessCheckUtil.checkNull(domainValueObject, BizCodeEnum.DOMAIN_VALUE_OBJECT_NOT_EXIST);
        EntityRelVO entityRelVO = domainEntityService.queryEntityRelVO(domainEntity.getEntityIdCode(), domainValueObject.getVoCode());
        BusinessCheckUtil.checkNonNull(entityRelVO, BizCodeEnum.ENTITY_REL_VO_IS_EXISTED);
        return ResultUtil.success(businessDomainDesign4Tactics.addEntityRelVO(domainCmdReqDTO.getDomainEntity(), domainCmdReqDTO.getDomainValueObject()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4DelEntityRelVO")
    public Result<Boolean> delEntityRelVO(DomainCmdReqDTO domainCmdReqDTO) {
        DomainEntity domainEntity = domainEntityService.queryDomainEntity(domainCmdReqDTO.getDomainEntity());
        BusinessCheckUtil.checkNull(domainEntity, BizCodeEnum.DOMAIN_ENTITY_NOT_EXIST);
        DomainValueObject domainValueObject = domainValueObjectService.queryDomainValueObject(domainCmdReqDTO.getDomainValueObject());
        BusinessCheckUtil.checkNull(domainValueObject, BizCodeEnum.DOMAIN_VALUE_OBJECT_NOT_EXIST);
        return ResultUtil.success(businessDomainDesign4Tactics.delEntityRelVO(domainCmdReqDTO.getDomainEntity(), domainCmdReqDTO.getDomainValueObject()));
    }

    @Override
    public Result<Boolean> addAggregate(DomainCmdReqDTO domainCmdReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.addAggregate(domainCmdReqDTO.getBusinessDomain(), domainCmdReqDTO.getDomainAggregate()));
    }

}
