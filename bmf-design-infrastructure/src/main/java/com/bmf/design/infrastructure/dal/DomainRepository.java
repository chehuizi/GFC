package com.bmf.design.infrastructure.dal;

import com.bmf.design.base.Domain;

import java.util.List;

public interface DomainRepository extends BaseRepository<Domain> {

    /**
     * 查询领域编码查询
     * @param domainCodeList
     * @return
     */
    List<Domain> selectByDomainCode(List<Integer> domainCodeList);

    /**
     * 根据业务编码查询领域列表
     * @param businessCode
     * @return
     */
    List<Domain> selectByBusinessCode(Integer businessCode);

    /**
     * 批量插入领域
     * @param domainList
     * @return
     */
    boolean batchInsert(List<Domain> domainList);

    boolean batchUpdate(List<Domain> domainList);

    boolean batchDelete(List<Domain> domainList);
}
