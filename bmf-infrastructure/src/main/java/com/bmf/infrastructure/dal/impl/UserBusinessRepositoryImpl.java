package com.bmf.infrastructure.dal.impl;

import com.bmf.base.user.UserBusiness;
import com.bmf.infrastructure.dal.UserBusinessRepository;
import com.bmf.infrastructure.dal.mapper.UserBusinessMapper;
import com.bmf.infrastructure.dal.po.UserBusinessPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessRepositoryImpl implements UserBusinessRepository {

    @Autowired
    private UserBusinessMapper userBusinessMapper;

    @Override
    public UserBusiness selectOne(UserBusiness req) {
        return null;
    }

    @Override
    public boolean insert(UserBusiness req) {
        UserBusinessPO userBusinessPO = POUtils.convert(req, UserBusinessPO.class);
        return userBusinessMapper.insert(userBusinessPO) == 1;
    }

    @Override
    public boolean update(UserBusiness req) {
        return false;
    }

    @Override
    public boolean delete(UserBusiness req) {
        return false;
    }
}
