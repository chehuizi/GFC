package com.bmf.base.snapshot;

import com.alibaba.fastjson.JSON;
import com.bmf.base.BaseModel;
import com.bmf.base.BusinessDomain;
import com.bmf.base.BusinessDomainRelation;
import com.bmf.base.BusinessRelDomain;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 领域战略设计快照
 * @author chehuizi
 */
@Builder
@Data
public class DomainStrategyDesignSnapshot extends BaseSnapshot {

    /**
     * 领域列表
     */
    private List<BusinessDomain> domainList;
    /**
     * 业务领域关系列表
     */
    private List<BusinessRelDomain> businessRelDomainList;
    /**
     * 领域关系列表
     */
    private List<BusinessDomainRelation> domainRelationList;

    @Override
    public String snapshot() {
        return JSON.toJSONString(this);
    }
}
