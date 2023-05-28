package com.bmf.infrastructure.dal;

import com.bmf.base.Business;

import java.util.List;

public interface BusinessRepository extends BaseRepository<Business> {

    /**
     * 根据业务编码查询
     * @param businessCodeList
     * @return
     */
    List<Business> selectByBusinessCode(List<Integer> businessCodeList);
}
