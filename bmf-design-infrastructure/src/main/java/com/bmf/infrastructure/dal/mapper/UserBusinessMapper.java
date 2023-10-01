package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.UserBusinessPO;

import java.util.List;

public interface UserBusinessMapper {

    UserBusinessPO selectOne(UserBusinessPO userBusinessPO);

    List<UserBusinessPO> selectByUser(Integer userId);

    int insert(UserBusinessPO userBusinessPO);

    int update(UserBusinessPO userBusinessPO);

    int delete(UserBusinessPO userBusinessPO);
}
