package com.bmf.design.api.impl.domain.qry;

import com.bmf.common.api.Result;
import com.bmf.design.api.domain.dto.DomainServiceQryReqDTO;
import com.bmf.design.api.domain.dto.DomainServiceRespDTO;
import com.bmf.design.api.domain.qry.DomainServiceQryService;
import com.bmf.design.model.Domain;
import com.bmf.common.api.enums.BizCodeEnum;
import com.bmf.common.utils.checker.BusinessCheckUtil;
import com.bmf.common.api.utils.ResultUtil;
import com.bmf.common.api.validator.Validator;
import com.bmf.design.core.domain.DomainService;
import com.bmf.design.core.domain.DomainServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainServiceQryServiceImpl implements DomainServiceQryService {

    @Autowired
    private DomainService domainService;
    @Autowired
    private DomainServiceService domainServiceService;

    @Override
    @Validator(beanName = "domainServiceReqDTOValidator", method = "v4QueryOne")
    public Result<DomainServiceRespDTO> queryOne(DomainServiceQryReqDTO req) {
        Domain domain = domainService.queryDomain(new Domain(req.getDomainService().getDomainCode()));
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        com.bmf.design.model.tactics.service.DomainService service = domainServiceService.queryDomainService(req.getDomainService());
        BusinessCheckUtil.checkNull(service, BizCodeEnum.DOMAIN_SERVICE_NOT_EXIST);
        DomainServiceRespDTO domainServiceRespDTO = new DomainServiceRespDTO();
        domainServiceRespDTO.setDomainService(service);
        if (req.isIncludeAttr()) {
            domainServiceRespDTO.setServiceAttrList(domainServiceService.queryServiceAttr(service.getServiceCode()));
        }
        return ResultUtil.success(domainServiceRespDTO);
    }
}
