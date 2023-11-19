package com.bmf.design.infrastructure.dal;

import com.bmf.design.model.BusinessRelDomain;

import java.util.List;

public interface BusinessRelDomainRepository extends BaseRepository<BusinessRelDomain> {

    /**
     * 查询业务下的领域列表
     * @param businessCode
     * @return
     */
    List<BusinessRelDomain> selectByBusinessCode(Integer businessCode);

    /**
     * 批量插入业务领域关系
     * @param businessRelDomainList
     * @return
     */
    boolean batchInsert(List<BusinessRelDomain> businessRelDomainList);

    /**
     * 批量更新业务领域关系
     * @param businessRelDomainList
     * @return
     */
    boolean batchUpdate(List<BusinessRelDomain> businessRelDomainList);

    /**
     * 按照业务编码删除
     * @param businessCode
     * @return
     */
    boolean deleteByBusinessCode(Integer businessCode);
}
