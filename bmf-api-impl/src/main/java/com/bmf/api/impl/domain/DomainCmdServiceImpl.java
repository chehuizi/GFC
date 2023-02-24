package com.bmf.api.impl.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.DomainCmdService;
import com.bmf.api.domain.dto.DomainReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.CodeKeyEnum;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.common.utils.DomainUtil;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.design.BusinessDomainDesign4Tactics;
import com.bmf.core.domain.DomainEntityService;
import com.bmf.core.domain.DomainService;
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
    private BusinessDomainDesign4Tactics businessDomainDesign4Tactics;
    @Autowired
    private CodeSeqGenerator codeSeqGenerator;

    @Override
    @Validator(beanName = "domainReqDTOValidator", method = "v4Create")
    public Result<Boolean> create(DomainReqDTO req) {
        BusinessDomain domain = DomainUtil.convert(req);
        BusinessDomain queryResult = domainService.queryDomain(domain);
        BusinessCheckUtil.checkNonNull(queryResult, BizCodeEnum.DOMAIN_IS_EXISTED);
        domain.setDomainCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_DOMAIN.getKey()));
        return ResultUtil.success(domainService.createDomain(domain));
    }

    @Override
    @Validator(beanName = "domainReqDTOValidator", method = "v4Update")
    public Result<Boolean> update(DomainReqDTO req) {
        BusinessDomain domain = DomainUtil.convert(req);
        BusinessDomain queryResult = domainService.queryDomain(domain);
        BusinessCheckUtil.checkNull(queryResult, BizCodeEnum.DOMAIN_NOT_EXIST);
        return ResultUtil.success(domainService.updateDomain(domain));
    }

    @Override
    @Validator(beanName = "domainReqDTOValidator", method = "v4Delete")
    public Result<Boolean> delete(DomainReqDTO req) {
        BusinessDomain domain = DomainUtil.convert(req);
        return ResultUtil.success(domainService.deleteDomain(domain));
    }

    @Override
    @Validator(beanName = "domainReqDTOValidator", method = "v4AddEntity")
    public Result<Boolean> addEntity(DomainReqDTO domainReqDTO) {
        BusinessDomain domain = domainService.queryDomain(domainReqDTO.getBusinessDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        DomainEntity domainEntity = domainEntityService.queryDomainEntity(domainReqDTO.getDomainEntity());
        BusinessCheckUtil.checkNonNull(domainEntity, BizCodeEnum.DOMAIN_ENTITY_IS_EXISTED);
        domainReqDTO.getDomainEntity().setEntityIdCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_ENTITY.getKey()));
        return ResultUtil.success(businessDomainDesign4Tactics.addEntity(domainReqDTO.getBusinessDomain(), domainReqDTO.getDomainEntity()));
    }

    @Override
    @Validator(beanName = "domainReqDTOValidator", method = "v4DelEntity")
    public Result<Boolean> delEntity(DomainReqDTO domainReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.delEntity(domainReqDTO.getDomainEntity()));
    }

    @Override
    @Validator(beanName = "domainReqDTOValidator", method = "v4AddService")
    public Result<Boolean> addService(DomainReqDTO domainReqDTO) {
        BusinessDomain domain = domainService.queryDomain(domainReqDTO.getBusinessDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        domainReqDTO.getDomainService().setServiceCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_SERVICE.getKey()));
        return ResultUtil.success(businessDomainDesign4Tactics.addService(domainReqDTO.getBusinessDomain(), domainReqDTO.getDomainService()));
    }

    @Override
    @Validator(beanName = "domainReqDTOValidator", method = "v4DelService")
    public Result<Boolean> delService(DomainReqDTO domainReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.delService(domainReqDTO.getDomainService()));
    }

    @Override
    @Validator(beanName = "domainReqDTOValidator", method = "v4AddValueObject")
    public Result<Boolean> addValueObject(DomainReqDTO domainReqDTO) {
        BusinessDomain domain = domainService.queryDomain(domainReqDTO.getBusinessDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        domainReqDTO.getDomainValueObject().setVoCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_VALUE_OBJECT.getKey()));
        return ResultUtil.success(businessDomainDesign4Tactics.addValueObject(domainReqDTO.getBusinessDomain(), domainReqDTO.getDomainValueObject()));
    }

    @Override
    @Validator(beanName = "domainReqDTOValidator", method = "v4DelValueObject")
    public Result<Boolean> delValueObject(DomainReqDTO domainReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.delValueObject(domainReqDTO.getDomainValueObject()));
    }

    @Override
    @Validator(beanName = "domainReqDTOValidator", method = "v4AddDomainEvent")
    public Result<Boolean> addDomainEvent(DomainReqDTO domainReqDTO) {
        BusinessDomain domain = domainService.queryDomain(domainReqDTO.getBusinessDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        domainReqDTO.getDomainEvent().setEventCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_EVENT.getKey()));
        return ResultUtil.success(businessDomainDesign4Tactics.addDomainEvent(domainReqDTO.getBusinessDomain(), domainReqDTO.getDomainEvent()));
    }

    @Override
    @Validator(beanName = "domainReqDTOValidator", method = "v4DelDomainEvent")
    public Result<Boolean> delDomainEvent(DomainReqDTO domainReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.delDomainEvent(domainReqDTO.getDomainEvent()));
    }

    @Override
    public Result<Boolean> addEntityRelVO(DomainReqDTO domainReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.addEntityRelVO(domainReqDTO.getDomainEntity(), domainReqDTO.getDomainValueObject()));
    }

    @Override
    public Result<Boolean> addAggregate(DomainReqDTO domainReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.addAggregate(domainReqDTO.getBusinessDomain(), domainReqDTO.getDomainAggregate()));
    }

}
