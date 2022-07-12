package com.bmf.base.tactics;

import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.aggregate.BusinessAggregate;
import com.bmf.base.tactics.entity.BusinessEntity;
import com.bmf.base.tactics.service.BusinessServiceTmp;
import com.bmf.base.tactics.valueObject.BusinessValueObject;

import java.util.List;

/**
 * 业务领域
 */
public class BusinessDomainInTactics extends BusinessDomain {

    /**
     * 领域实体列表
     */
    List<BusinessEntity> entityList;
    /**
     * 领域服务列表
     */
    List<BusinessServiceTmp> serviceList;
    /**
     * 值对象列表
     */
    List<BusinessValueObject> valueObjectList;
    /**
     * 聚合根列表
     */
    List<BusinessAggregate> aggregateList;

}
