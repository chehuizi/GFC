package com.bmf.core.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.api.business.BusinessRespDTO;
import com.bmf.infrastructure.dal.BusinessRepository;

import javax.annotation.Resource;

public class BusinessCmdServiceImpl implements BusinessCmdService {

    @Resource
    private BusinessRepository businessRepository;

    @Override
    public Result<Boolean> create(BusinessReqDTO req) {
        boolean ret = businessRepository.insert(req);
        return null;
    }

    @Override
    public Result<Boolean> update(BusinessReqDTO req) {
        return null;
    }

    @Override
    public Result<Boolean> delete(BusinessReqDTO req) {
        return null;
    }

    @Override
    public Result<BusinessRespDTO> queryOne(BusinessReqDTO req) {
        return null;
    }
}
