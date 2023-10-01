package com.bmf.design.api.impl.domain.qry;

import com.bmf.design.api.Result;
import com.bmf.design.api.domain.dto.DomainEntityQryReqDTO;
import com.bmf.design.api.domain.dto.DomainEntityRespDTO;
import com.bmf.design.api.domain.qry.DomainEntityQryService;
import com.bmf.design.base.Domain;
import com.bmf.design.base.tactics.entity.DomainEntity;
import com.bmf.design.common.enums.BizCodeEnum;
import com.bmf.design.common.utils.BusinessCheckUtil;
import com.bmf.design.common.utils.ResultUtil;
import com.bmf.design.common.validator.Validator;
import com.bmf.design.core.domain.DomainEntityService;
import com.bmf.design.core.domain.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainEntityQryServiceImpl implements DomainEntityQryService {

    @Autowired
    private DomainService domainService;
    @Autowired
    private DomainEntityService domainEntityService;

    @Override
    @Validator(beanName = "domainEntityReqDTOValidator", method = "v4QueryOne")
    public Result<DomainEntityRespDTO> queryOne(DomainEntityQryReqDTO req) {
        Domain domain = domainService.queryDomain(new Domain(req.getDomainEntity().getDomainCode()));
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        DomainEntity domainEntity = domainEntityService.queryDomainEntity(req.getDomainEntity());
        BusinessCheckUtil.checkNull(domainEntity, BizCodeEnum.DOMAIN_ENTITY_NOT_EXIST);
        DomainEntityRespDTO domainEntityRespDTO = new DomainEntityRespDTO();
        domainEntityRespDTO.setDomainEntity(domainEntity);
        if (req.isIncludeAttr()) {
            domainEntityRespDTO.setEntityAttrList(domainEntityService.queryEntityAttr(domainEntity.getEntityIdCode()));
        }
        if (req.isIncludeVo()) {
            domainEntityRespDTO.setVoList(domainEntityService.queryEntityVO(domainEntity.getEntityIdCode()));
        }
        return ResultUtil.success(domainEntityRespDTO);
    }
}
