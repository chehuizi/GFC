package com.bmf.api.impl.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.DomainCmdService;
import com.bmf.api.domain.dto.DomainReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.CodeKeyEnum;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.common.utils.DomainUtil;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.design.BusinessDomainDesign4Tactics;
import com.bmf.core.domain.DomainService;
import com.bmf.infrastructure.generator.CodeSeqGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainCmdServiceImpl implements DomainCmdService {

    @Autowired
    private DomainService domainService;
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
        fillDomainInfo(domain);
        return ResultUtil.success(domainService.createDomain(domain));
    }

    /**
     * 填充领域信息
     * @param businessDomain
     */
    private void fillDomainInfo(BusinessDomain businessDomain) {
        businessDomain.setDomainCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_DOMAIN.getKey()));
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
        domainReqDTO.getDomainEntity().setEntityIdCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_ENTITY.getKey()));
        return ResultUtil.success(businessDomainDesign4Tactics.addEntity(domainReqDTO.getBusinessDomain(), domainReqDTO.getDomainEntity()));
    }

    @Override
    public Result<Boolean> delEntity(DomainReqDTO domainReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.delEntity(domainReqDTO.getDomainEntity()));
    }

    @Override
    public Result<Boolean> addValueObject(DomainReqDTO domainReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.addValueObject(domainReqDTO.getBusinessDomain(), domainReqDTO.getDomainValueObject()));
    }

    @Override
    public Result<Boolean> addEntityRelVO(DomainReqDTO domainReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.addEntityRelVO(domainReqDTO.getDomainEntity(), domainReqDTO.getDomainValueObject()));
    }

    @Override
    public Result<Boolean> addAggregate(DomainReqDTO domainReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.addAggregate(domainReqDTO.getBusinessDomain(), domainReqDTO.getDomainAggregate()));
    }

    @Override
    public Result<Boolean> addService(DomainReqDTO domainReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.addService(domainReqDTO.getBusinessDomain(), domainReqDTO.getDomainService()));
    }

    @Override
    public Result<Boolean> addDomainEvent(DomainReqDTO domainReqDTO) {
        return ResultUtil.success(businessDomainDesign4Tactics.addDomainEvent(domainReqDTO.getBusinessDomain(), domainReqDTO.getDomainEvent()));
    }
}
