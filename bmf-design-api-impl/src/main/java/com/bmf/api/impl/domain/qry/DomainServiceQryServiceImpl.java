package com.bmf.api.impl.domain.qry;

import com.bmf.api.Result;
import com.bmf.api.domain.dto.DomainServiceQryReqDTO;
import com.bmf.api.domain.dto.DomainServiceRespDTO;
import com.bmf.api.domain.qry.DomainServiceQryService;
import com.bmf.base.Domain;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.domain.DomainService;
import com.bmf.core.domain.DomainServiceService;
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
        com.bmf.base.tactics.service.DomainService service = domainServiceService.queryDomainService(req.getDomainService());
        BusinessCheckUtil.checkNull(service, BizCodeEnum.DOMAIN_SERVICE_NOT_EXIST);
        DomainServiceRespDTO domainServiceRespDTO = new DomainServiceRespDTO();
        domainServiceRespDTO.setDomainService(service);
        if (req.isIncludeAttr()) {
            domainServiceRespDTO.setServiceAttrList(domainServiceService.queryServiceAttr(service.getServiceCode()));
        }
        return ResultUtil.success(domainServiceRespDTO);
    }
}
