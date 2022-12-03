package com.bmf.controller;

import com.alibaba.fastjson.JSON;
import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.BusinessQryService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.api.business.BusinessRespDTO;
import com.bmf.base.Business;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "business")
public class BusinessController {

    private static final Logger logger = LoggerFactory.getLogger(BusinessController.class);

    @Autowired
    private BusinessQryService businessQryService;
    @Autowired
    private BusinessCmdService businessCmdService;

    @GetMapping("detail")
    public String detail() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        Business business = new Business();
        business.setBusinessCode(10);
        businessReqDTO.setBusiness(business);
        businessReqDTO.setIncludeDomain(true);
        Result<BusinessRespDTO> result = businessQryService.queryOne(businessReqDTO);
        return JSON.toJSONString(result);
    }
}
