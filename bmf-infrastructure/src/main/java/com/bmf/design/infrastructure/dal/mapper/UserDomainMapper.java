package com.bmf.design.infrastructure.dal.mapper;

import com.bmf.design.infrastructure.dal.po.UserDomainPO;

public interface UserDomainMapper {

    UserDomainPO selectOne(UserDomainPO userDomainPO);

    int insert(UserDomainPO userDomainPO);

    int update(UserDomainPO userDomainPO);

    int delete(UserDomainPO userDomainPO);
}
