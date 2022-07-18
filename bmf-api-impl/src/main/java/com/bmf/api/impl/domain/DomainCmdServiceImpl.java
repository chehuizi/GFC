package com.bmf.api.impl.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.DomainCmdService;
import com.bmf.api.domain.DomainReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.common.utils.DomainUtil;
import com.bmf.core.domain.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainCmdServiceImpl implements DomainCmdService {

    @Autowired
    private DomainService domainService;

    @Override
    public Result<Boolean> create(DomainReqDTO req) {
        BusinessDomain domain = DomainUtil.convert(req);
        boolean result = domainService.createDomain(domain);
        return Result.success(result);
    }

    @Override
    public Result<Boolean> update(DomainReqDTO req) {
        return null;
    }

    @Override
    public Result<Boolean> delete(DomainReqDTO req) {
        return null;
    }

}
