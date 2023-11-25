package com.bmf.design.infrastructure.dal.mapper;

import com.bmf.design.infrastructure.dal.po.UserPO;

public interface UserMapper {

    UserPO selectOne(UserPO userPO);

    int insert(UserPO userPO);

    int update(UserPO userPO);

    int delete(UserPO userPO);
}
