package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.model.user.UserBusiness;
import com.bmf.design.infrastructure.dal.mapper.UserBusinessMapper;
import com.bmf.design.infrastructure.dal.po.UserBusinessPO;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.UserBusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBusinessRepositoryImpl implements UserBusinessRepository {

    @Autowired
    private UserBusinessMapper userBusinessMapper;

    @Override
    public UserBusiness selectOne(UserBusiness req) {
        UserBusinessPO userBusinessPO = POUtils.convert(req, UserBusinessPO.class);
        return POUtils.convert(userBusinessMapper.selectOne(userBusinessPO), UserBusiness.class);
    }

    @Override
    public List<UserBusiness> selectByUser(Integer userId) {
        return POUtils.convert(userBusinessMapper.selectByUser(userId), UserBusiness.class);
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
