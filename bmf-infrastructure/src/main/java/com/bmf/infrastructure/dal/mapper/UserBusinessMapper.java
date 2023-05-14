package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.UserBusinessPO;

public interface UserBusinessMapper {

    UserBusinessPO selectOne(UserBusinessPO userBusinessPO);

    int insert(UserBusinessPO userBusinessPO);

    int update(UserBusinessPO userBusinessPO);

    int delete(UserBusinessPO userBusinessPO);
}
