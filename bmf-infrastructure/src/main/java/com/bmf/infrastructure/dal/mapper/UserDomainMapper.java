package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.UserDomainPO;

public interface UserDomainMapper {

    UserDomainPO selectOne(UserDomainPO userDomainPO);

    int insert(UserDomainPO userDomainPO);

    int update(UserDomainPO userDomainPO);

    int delete(UserDomainPO userDomainPO);
}
