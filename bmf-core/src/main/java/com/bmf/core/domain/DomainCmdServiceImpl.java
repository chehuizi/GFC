package com.bmf.core.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.DomainCmdService;
import com.bmf.api.domain.DomainReqDTO;
import com.bmf.api.domain.DomainRespDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.core.utils.DomainUtil;
import com.bmf.infrastructure.dal.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainCmdServiceImpl implements DomainCmdService {

    @Autowired
    private DomainRepository domainRepository;

    @Override
    public Result<Boolean> create(DomainReqDTO req) {
        BusinessDomain domain = DomainUtil.convert(req);
        boolean result = domainRepository.insert(domain);
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

    @Override
    public Result<DomainRespDTO> queryOne(DomainReqDTO req) {
        return null;
    }
}
