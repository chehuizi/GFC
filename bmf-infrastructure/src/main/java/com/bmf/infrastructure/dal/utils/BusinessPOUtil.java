package com.bmf.infrastructure.dal.utils;

import com.bmf.base.Business;
import com.bmf.infrastructure.dal.po.BusinessPO;

/**
 * 工具类
 */
public class BusinessPOUtil {

    /**
     * 转换DO到PO
     * @param business
     * @return
     */
    public static BusinessPO convert(Business business) {
        BusinessPO businessPO = new BusinessPO();
        businessPO.setBusinessCode(business.getBusinessCode());
        businessPO.setBusinessName(business.getBusinessName());
        return businessPO;
    }

    public static Business convert(BusinessPO businessPO) {
        Business business = new Business();
        business.setBusinessCode(businessPO.getBusinessCode());
        business.setBusinessName(businessPO.getBusinessName());
        return business;
    }
}
