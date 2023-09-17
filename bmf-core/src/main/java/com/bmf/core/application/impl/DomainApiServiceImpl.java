package com.bmf.core.application.impl;

import com.bmf.api.application.dto.DomainApiCmdReqDTO;
import com.bmf.base.application.DomainApi;
import com.bmf.core.application.DomainApiService;
import com.bmf.infrastructure.dal.DomainApiRepository;
import com.bmf.infrastructure.dal.DomainAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainApiServiceImpl implements DomainApiService {

    @Autowired
    private DomainAppRepository domainAppRepository;
    @Autowired
    private DomainApiRepository domainApiRepository;

    @Override
    public boolean createApi(DomainApiCmdReqDTO req) {
        boolean result = domainAppRepository.insert(req.getDomainApp());
        if (result) {
            return domainApiRepository.batchInsert(req.getDomainApiList());
        }
        return false;
    }
}
