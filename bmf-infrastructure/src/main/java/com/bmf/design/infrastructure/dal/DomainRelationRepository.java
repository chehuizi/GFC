package com.bmf.design.infrastructure.dal;

import com.bmf.design.model.DomainRelation;

import java.util.List;

public interface DomainRelationRepository extends BaseRepository<DomainRelation> {

    List<DomainRelation> selectByBusinessCode(Integer businessCode);

    List<DomainRelation> selectByDomain(DomainRelation req);

    boolean batchInsert(List<DomainRelation> domainRelationList);

    boolean deleteByBusinessCode(Integer businessCode);
}
