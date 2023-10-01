package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessRolePO;

public interface BusinessRoleMapper {

    BusinessRolePO selectOne(BusinessRolePO businessRolePO);

    int insert(BusinessRolePO businessRolePO);

    int update(BusinessRolePO businessRolePO);

    int delete(BusinessRolePO businessRolePO);
}
