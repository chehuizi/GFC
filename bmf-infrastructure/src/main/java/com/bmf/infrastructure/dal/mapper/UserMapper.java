package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.UserPO;

public interface UserMapper {

    UserPO selectOne(UserPO userPO);

    int insert(UserPO userPO);

    int update(UserPO userPO);

    int delete(UserPO userPO);
}
