package com.bmf.design.model.tactics.aggregate;

import com.bmf.common.model.BaseModel;
import com.bmf.design.model.tactics.entity.DomainEntity;
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
