package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessPO;

public interface BusinessMapper {

    BusinessPO selectOne(BusinessPO businessPO);

    int insert(BusinessPO businessPO);

    int update(BusinessPO businessPO);

    int delete(BusinessPO businessPO);
}
