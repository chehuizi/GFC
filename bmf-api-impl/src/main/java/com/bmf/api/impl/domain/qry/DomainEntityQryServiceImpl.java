package com.bmf.api.impl.domain.qry;

import com.bmf.api.Result;
import com.bmf.api.domain.dto.DomainEntityQryReqDTO;
import com.bmf.api.domain.dto.DomainEntityRespDTO;
import com.bmf.api.domain.qry.DomainEntityQryService;
import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.domain.DomainEntityService;
import com.bmf.core.domain.DomainService;
import com.bmf.core.domain.DomainValueObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainEntityQryServiceImpl implements DomainEntityQryService {

    @Autowired
    private DomainService domainService;
    @Autowired
    private DomainEntityService domainEntityService;
    @Autowired
    private DomainValueObjectService domainValueObjectService;

    @Override
    @Validator(beanName = "domainEntityReqDTOValidator", method = "v4QueryOne")
    public Result<DomainEntityRespDTO> queryOne(DomainEntityQryReqDTO req) {
        BusinessDomain domain = domainService.queryDomain(new BusinessDomain(req.getDomainEntity().getDomainCode()));
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        DomainEntity domainEntity = domainEntityService.queryDomainEntity(req.getDomainEntity());
        BusinessCheckUtil.checkNonNull(domainEntity, BizCodeEnum.DOMAIN_ENTITY_IS_EXISTED);
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
