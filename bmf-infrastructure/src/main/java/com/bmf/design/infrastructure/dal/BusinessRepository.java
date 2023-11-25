package com.bmf.design.infrastructure.dal;

import com.bmf.design.model.Business;

import java.util.List;

public interface BusinessRepository extends BaseRepository<Business> {

    /**
     * 根据业务编码查询
     * @param businessCodeList
     * @return
     */
    List<Business> selectByBusinessCode(List<Integer> businessCodeList);
}
