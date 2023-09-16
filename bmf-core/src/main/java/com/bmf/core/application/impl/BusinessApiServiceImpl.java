package com.bmf.core.application.impl;

import com.bmf.base.application.DomainApi;
import com.bmf.core.application.BusinessApiService;
import com.bmf.infrastructure.dal.BusinessApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessApiServiceImpl implements BusinessApiService {

    @Autowired
    private BusinessApiRepository businessApiRepository;

    @Override
    public boolean createBusinessApi(List<DomainApi> domainApiList) {
        return businessApiRepository.batchInsert(domainApiList);
    }
}
