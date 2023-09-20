package com.bmf.core.application.impl;

import com.bmf.api.application.dto.DomainApiCmdReqDTO;
import com.bmf.api.application.dto.DomainApiQryReqDTO;
import com.bmf.base.application.DomainApi;
import com.bmf.base.application.DomainApp;
import com.bmf.core.application.DomainApiService;
import com.bmf.infrastructure.dal.DomainApiRepository;
import com.bmf.infrastructure.dal.DomainAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DomainApiServiceImpl implements DomainApiService {

    @Autowired
    private DomainAppRepository domainAppRepository;
    @Autowired
    private DomainApiRepository domainApiRepository;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean createApi(DomainApiCmdReqDTO req) {
        boolean result = domainAppRepository.insert(req.getDomainApp());
        if (result) {
            return domainApiRepository.batchInsert(req.getDomainApiList());
        }
        return false;
    }

    @Override
    public DomainApp queryApp(DomainApiQryReqDTO req) {
        return domainAppRepository.selectByDomainCode(req.getDomainCode());
    }

    @Override
    public List<DomainApi> queryApi(DomainApiQryReqDTO req) {
        return domainApiRepository.selectByDomainCode(req.getDomainCode());
    }
}
