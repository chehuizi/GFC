package com.bmf.infrastructure.dal;

import com.bmf.base.tactics.service.DomainServiceAttr;

import java.util.List;

public interface DomainServiceAttrRepository extends BaseRepository<DomainServiceAttr> {

    /**
     * 根据服务code查询属性
     * @param serviceCode
     * @return
     */
    List<DomainServiceAttr> selectByServiceCode(Integer serviceCode);
}