package com.bmf.core.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.DomainQryService;
import com.bmf.api.domain.DomainReqDTO;
import com.bmf.api.domain.DomainRespDTO;
import com.bmf.core.utils.DomainUtil;
import com.bmf.infrastructure.dal.DomainRepository;
import com.bmf.infrastructure.dal.po.DomainPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainQryServiceImpl implements DomainQryService {

    @Autowired
    private DomainRepository domainRepository;

    @Override
    public Result<DomainRespDTO> queryOne(DomainReqDTO req) {
        DomainPO domainPO = domainRepository.selectOne(req);
        return Result.success(DomainUtil.convert(domainPO));
    }
}
