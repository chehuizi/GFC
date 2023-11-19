package com.bmf.dev.core.application.impl;

import com.bmf.dev.api.application.dto.DomainAppCmdReqDTO;
import com.bmf.dev.api.application.dto.DomainAppQryReqDTO;
import com.bmf.dev.model.application.DomainApp;
import com.bmf.dev.model.application.DomainAppApi;
import com.bmf.dev.core.application.DomainAppService;
import com.bmf.design.infrastructure.dal.DomainAppApiRepository;
import com.bmf.design.infrastructure.dal.DomainAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DomainAppServiceImpl implements DomainAppService {

    @Autowired
    private DomainAppRepository domainAppRepository;
    @Autowired
    private DomainAppApiRepository domainApiRepository;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean createApi(DomainAppCmdReqDTO req) {
        boolean result = domainAppRepository.insert(req.getDomainApp());
        if (result) {
            return domainApiRepository.batchInsert(req.getDomainAppApiList());
        }
        return false;
    }

    @Override
    public DomainApp queryApp(DomainAppQryReqDTO req) {
        return domainAppRepository.selectByDomainCode(req.getDomainCode());
    }

    @Override
    public List<DomainAppApi> queryApi(DomainAppQryReqDTO req) {
        return domainApiRepository.selectByDomainCode(req.getDomainCode());
    }
}
