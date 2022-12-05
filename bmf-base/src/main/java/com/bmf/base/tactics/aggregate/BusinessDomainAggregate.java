package com.bmf.base.tactics.aggregate;

import com.bmf.base.BaseModel;
import com.bmf.base.tactics.entity.BusinessDomainEntity;
import lombok.Data;

import java.util.List;

@Data
public class BusinessDomainAggregate extends BaseModel {

    /**
     * 聚合根名称
     */
    private String aggregateName;
    /**
     * 实体列表
     */
    private List<BusinessDomainEntity> entityList;
}
