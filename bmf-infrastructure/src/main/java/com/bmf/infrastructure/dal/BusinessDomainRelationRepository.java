package com.bmf.infrastructure.dal;

import com.bmf.base.BusinessDomainRelation;
import com.bmf.infrastructure.dal.po.BusinessDomainRelationPO;

import java.util.List;

public interface BusinessDomainRelationRepository extends BaseRepository<BusinessDomainRelation> {

    List<BusinessDomainRelationPO> selectList(BusinessDomainRelation req);

    List<BusinessDomainRelationPO> selectByDomain(BusinessDomainRelation req);
}
