package com.bmf.api.impl.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessQryService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.api.business.BusinessRespDTO;
import com.bmf.base.Business;
import com.bmf.common.utils.ResultUtil;
import com.bmf.core.business.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessQryServiceImpl implements BusinessQryService {

    @Autowired
    private BusinessService businessService;

    @Override
    public Result<BusinessRespDTO> queryOne(BusinessReqDTO req) {
        Business business = businessService.queryBusiness(req.getBusiness());
        BusinessRespDTO respDTO = new BusinessRespDTO(business);
        return ResultUtil.success(respDTO);
    }
}
