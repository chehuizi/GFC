package com.chz.bmf.domain;

import com.chz.bmf.common.BusinessDomainLevelEnum;
import com.chz.bmf.common.BusinessDomainNameEnum;
import com.chz.bmf.entity.BusinessEntity4Domain;
import com.chz.bmf.service.BusinessService4Domain;
import lombok.Data;

import java.util.List;

/**
 * 业务域
 */
@Data
public class BusinessDomain {

    /**
     * 等级
     */
    private BusinessDomainLevelEnum level;
    /**
     * 名称
     */
    private BusinessDomainNameEnum  name;
    /**
     * 领域实体列表
     */
    private List<BusinessEntity4Domain> entityList;
    /**
     * 领域服务列表
     */
    private List<BusinessService4Domain> serviceList;

}
