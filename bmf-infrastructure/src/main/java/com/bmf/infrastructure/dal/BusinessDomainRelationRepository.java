package com.bmf.infrastructure.dal;

import com.bmf.base.BusinessDomainRelation;
import com.bmf.infrastructure.dal.po.BusinessDomainRelationPO;

import java.util.List;

public interface BusinessDomainRelationRepository extends BaseRepository<BusinessDomainRelation> {

    List<BusinessDomainRelation> selectList(BusinessDomainRelation req);

    List<BusinessDomainRelation> selectByDomain(BusinessDomainRelation req);

    boolean batchInsert(List<BusinessDomainRelation> businessDomainRelationList);
}
