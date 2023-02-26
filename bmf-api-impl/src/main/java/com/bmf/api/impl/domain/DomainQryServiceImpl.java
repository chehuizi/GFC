package com.bmf.api.impl.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.DomainQryService;
import com.bmf.api.domain.dto.DomainQryReqDTO;
import com.bmf.api.domain.dto.DomainRespDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.common.utils.DomainUtil;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.domain.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainQryServiceImpl implements DomainQryService {

    @Autowired
    private DomainService domainService;

    @Override
    @Validator(beanName = "domainQryReqDTOValidator", method = "v4QueryOne")
    public Result<DomainRespDTO> queryOne(DomainQryReqDTO req) {
        BusinessDomain domain = DomainUtil.convert(req);
        BusinessDomain result = domainService.queryDomain(domain);
        DomainRespDTO respDTO = new DomainRespDTO(result);
        return ResultUtil.success(respDTO);
    }

    @Override
    public Result<DomainRespDTO> queryByBusiness(DomainQryReqDTO domainQryReqDTO) {
        return null;
    }
}
