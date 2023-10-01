package com.bmf.base.tactics.aggregate;

import com.bmf.base.BaseModel;
import com.bmf.base.tactics.entity.DomainEntity;
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
