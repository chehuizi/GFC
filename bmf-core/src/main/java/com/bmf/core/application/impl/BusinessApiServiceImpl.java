package com.bmf.core.application.impl;

import com.bmf.base.application.DomainApi;
import com.bmf.core.application.BusinessApiService;
import com.bmf.infrastructure.dal.DomainApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessApiServiceImpl implements BusinessApiService {

    @Autowired
    private DomainApiRepository domainApiRepository;

    @Override
    public boolean createBusinessApi(List<DomainApi> domainApiList) {
        return domainApiRepository.batchInsert(domainApiList);
    }
}
