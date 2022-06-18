package com.bmf.infrastructure.dal.utils;

import com.bmf.api.business.BusinessReqDTO;
import com.bmf.api.domain.DomainReqDTO;
import com.bmf.infrastructure.dal.po.BusinessPO;
import com.bmf.infrastructure.dal.po.DomainPO;

/**
 * 工具类
 */
public class BusinessPOUtil {

    /**
     * 转换DTO到PO
     * @param businessReqDTO
     * @return
     */
    public static BusinessPO convert(BusinessReqDTO businessReqDTO) {
        BusinessPO businessPO = new BusinessPO();
        businessPO.setBusinessCode(businessReqDTO.getBusiness().getBusinessCode());
        businessPO.setBusinessName(businessReqDTO.getBusiness().getBusinessName());
        return businessPO;
    }
}
