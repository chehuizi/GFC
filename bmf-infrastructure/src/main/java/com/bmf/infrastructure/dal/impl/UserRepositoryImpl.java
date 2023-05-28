package com.bmf.infrastructure.dal.impl;

import com.bmf.base.user.User;
import com.bmf.infrastructure.dal.UserRepository;
import com.bmf.infrastructure.dal.mapper.UserMapper;
import com.bmf.infrastructure.dal.po.UserPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectOne(User req) {
        UserPO userPO = POUtils.convert(req, UserPO.class);
        return POUtils.convert(userMapper.selectOne(userPO), User.class);
    }

    @Override
    public boolean insert(User req) {
        UserPO userPO = POUtils.convert(req, UserPO.class);
        return userMapper.insert(userPO) == 1;
    }

    @Override
    public boolean update(User req) {
        return false;
    }

    @Override
    public boolean delete(User req) {
        return false;
    }
}
