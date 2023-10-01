package com.bmf.design.base.snapshot;

import com.alibaba.fastjson.JSONObject;
import com.bmf.design.base.BusinessRelDomain;
import com.bmf.design.base.Domain;
import com.bmf.design.base.DomainRelation;
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
    private List<Domain> domainList;
    /**
     * 业务领域关系列表
     */
    private List<BusinessRelDomain> businessRelDomainList;
    /**
     * 领域关系列表
     */
    private List<DomainRelation> domainRelationList;

    @Override
    public String getSnapshotContent() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("domainList", domainList);
        jsonObject.put("businessRelDomainList", businessRelDomainList);
        jsonObject.put("domainRelationList", domainRelationList);
        return jsonObject.toJSONString();
    }
}
