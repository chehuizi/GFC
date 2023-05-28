package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessMapper {

    BusinessPO selectOne(BusinessPO businessPO);

    List<BusinessPO> selectByBusinessCode(@Param("businessCodeList") List<Integer> businessCodeList);

    int insert(BusinessPO businessPO);

    int update(BusinessPO businessPO);

    int delete(BusinessPO businessPO);
}
