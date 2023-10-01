package com.bmf.design.api.impl.domain.cmd;

import com.bmf.design.api.Result;
import com.bmf.design.api.domain.cmd.DomainCmdService;
import com.bmf.design.api.domain.dto.DomainCmdReqDTO;
import com.bmf.design.base.Domain;
import com.bmf.design.base.enums.CodeKeyEnum;
import com.bmf.design.base.tactics.entity.DomainEntityRelVO;
import com.bmf.design.base.tactics.entity.DomainEntity;
import com.bmf.design.base.tactics.valueobject.DomainValueObject;
import com.bmf.design.common.enums.BizCodeEnum;
import com.bmf.design.common.utils.BusinessCheckUtil;
import com.bmf.design.common.utils.ResultUtil;
import com.bmf.design.common.validator.Validator;
import com.bmf.design.core.design.BusinessDomainDesign4Tactics;
import com.bmf.design.core.domain.DomainEntityService;
import com.bmf.design.core.domain.DomainService;
import com.bmf.design.core.domain.DomainValueObjectService;
import com.bmf.design.infrastructure.generator.CodeSeqGenerator;
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
        Domain domain = req.getDomain();
        Domain queryResult = domainService.queryDomain(domain);
        BusinessCheckUtil.checkNonNull(queryResult, BizCodeEnum.DOMAIN_IS_EXISTED);
        domain.setDomainCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_DOMAIN.getKey()));
        return ResultUtil.success(domainService.createDomain(domain));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4Update")
    public Result<Boolean> update(DomainCmdReqDTO req) {
        Domain domain = req.getDomain();
        Domain queryResult = domainService.queryDomain(domain);
        BusinessCheckUtil.checkNull(queryResult, BizCodeEnum.DOMAIN_NOT_EXIST);
        return ResultUtil.success(domainService.updateDomain(domain));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4Delete")
    public Result<Boolean> delete(DomainCmdReqDTO req) {
        Domain domain = req.getDomain();
        Domain queryResult = domainService.queryDomain(domain);
        BusinessCheckUtil.checkNull(queryResult, BizCodeEnum.DOMAIN_NOT_EXIST);
        return ResultUtil.success(domainService.deleteDomain(domain));
    }

    @Override
    public Result<Boolean> addDsl(DomainCmdReqDTO domainCmdReqDTO) {
        Domain domain = domainCmdReqDTO.getDomain();
        Domain queryResult = domainService.queryDomain(domain);
        BusinessCheckUtil.checkNull(queryResult, BizCodeEnum.DOMAIN_NOT_EXIST);
        domainCmdReqDTO.getDslBase().setDslCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_DSL.getKey()));
        return ResultUtil.success(domainService.addDsl(domainCmdReqDTO.getDslBase()));
    }

    @Override
    public Result<Boolean> delDsl(DomainCmdReqDTO domainCmdReqDTO) {
        return ResultUtil.success(domainService.delDsl(domainCmdReqDTO.getDslBase()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4AddEntity")
    public Result<Boolean> addEntity(DomainCmdReqDTO domainCmdReqDTO) {
        Domain domain = domainService.queryDomain(domainCmdReqDTO.getDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        DomainEntity domainEntity = domainEntityService.queryDomainEntity(domainCmdReqDTO.getDomainEntity());
        BusinessCheckUtil.checkNonNull(domainEntity, BizCodeEnum.DOMAIN_ENTITY_IS_EXISTED);
        domainCmdReqDTO.getDomainEntity().setEntityIdCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_ENTITY.getKey()));
        return ResultUtil.success(businessDomainDesign4Tactics.addEntity(domainCmdReqDTO.getDomain(), domainCmdReqDTO.getDomainEntity()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4DelEntity")
    public Result<Boolean> delEntity(DomainCmdReqDTO domainCmdReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.delEntity(domainCmdReqDTO.getDomainEntity()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4AddService")
    public Result<Boolean> addService(DomainCmdReqDTO domainCmdReqDTO) {
        Domain domain = domainService.queryDomain(domainCmdReqDTO.getDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        domainCmdReqDTO.getDomainService().setServiceCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_SERVICE.getKey()));
        return ResultUtil.success(businessDomainDesign4Tactics.addService(domainCmdReqDTO.getDomain(), domainCmdReqDTO.getDomainService()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4DelService")
    public Result<Boolean> delService(DomainCmdReqDTO domainCmdReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.delService(domainCmdReqDTO.getDomainService()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4AddValueObject")
    public Result<Boolean> addValueObject(DomainCmdReqDTO domainCmdReqDTO) {
        Domain domain = domainService.queryDomain(domainCmdReqDTO.getDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        domainCmdReqDTO.getDomainValueObject().setVoCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_VALUE_OBJECT.getKey()));
        return ResultUtil.success(businessDomainDesign4Tactics.addValueObject(domainCmdReqDTO.getDomain(), domainCmdReqDTO.getDomainValueObject()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4DelValueObject")
    public Result<Boolean> delValueObject(DomainCmdReqDTO domainCmdReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.delValueObject(domainCmdReqDTO.getDomainValueObject()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4AddDomainEvent")
    public Result<Boolean> addEvent(DomainCmdReqDTO domainCmdReqDTO) {
        Domain domain = domainService.queryDomain(domainCmdReqDTO.getDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        domainCmdReqDTO.getDomainEvent().setEventCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_EVENT.getKey()));
        return ResultUtil.success(businessDomainDesign4Tactics.addDomainEvent(domainCmdReqDTO.getDomain(), domainCmdReqDTO.getDomainEvent()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4DelDomainEvent")
    public Result<Boolean> delEvent(DomainCmdReqDTO domainCmdReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.delDomainEvent(domainCmdReqDTO.getDomainEvent()));
    }

    @Override
    @Validator(beanName = "domainCmdReqDTOValidator", method = "v4AddEntityRelVO")
    public Result<Boolean> addEntityRelVO(DomainCmdReqDTO domainCmdReqDTO) {
        DomainEntity domainEntity = domainEntityService.queryDomainEntity(domainCmdReqDTO.getDomainEntity());
        BusinessCheckUtil.checkNull(domainEntity, BizCodeEnum.DOMAIN_ENTITY_NOT_EXIST);
        DomainValueObject domainValueObject = domainValueObjectService.queryDomainValueObject(domainCmdReqDTO.getDomainValueObject());
        BusinessCheckUtil.checkNull(domainValueObject, BizCodeEnum.DOMAIN_VALUE_OBJECT_NOT_EXIST);
        DomainEntityRelVO domainEntityRelVO = domainEntityService.queryEntityRelVO(domainEntity.getEntityIdCode(), domainValueObject.getVoCode());
        BusinessCheckUtil.checkNonNull(domainEntityRelVO, BizCodeEnum.ENTITY_REL_VO_IS_EXISTED);
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
        return ResultUtil.success(businessDomainDesign4Tactics.addAggregate(domainCmdReqDTO.getDomain(), domainCmdReqDTO.getDomainAggregate()));
    }

}
