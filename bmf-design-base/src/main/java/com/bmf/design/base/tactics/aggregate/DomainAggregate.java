package com.bmf.design.base.tactics.aggregate;

import com.bmf.design.base.BaseModel;
import com.bmf.design.base.tactics.entity.DomainEntity;
import lombok.Data;

import java.util.List;

@Data
public class DomainAggregate extends BaseModel {

    /**
     * 聚合根名称
     */
    private String aggregateName;
    /**
     * 实体列表
     */
    private List<DomainEntity> entityList;
}
