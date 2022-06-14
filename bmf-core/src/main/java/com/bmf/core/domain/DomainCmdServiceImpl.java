package com.bmf.core.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.DomainCmdService;
import com.bmf.api.domain.DomainReqDTO;
import com.bmf.api.domain.DomainRespDTO;
import com.bmf.infrastructure.dal.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DomainCmdServiceImpl implements DomainCmdService {

    @Autowired
    private DomainRepository domainRepository;

    @Override
    public Result<Boolean> create(DomainReqDTO req) {
        boolean result = domainRepository.insert(req);
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
