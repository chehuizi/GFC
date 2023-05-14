package com.bmf.infrastructure.dal.impl;

import com.bmf.base.user.UserDomain;
import com.bmf.infrastructure.dal.UserDomainRepository;
import com.bmf.infrastructure.dal.mapper.UserDomainMapper;
import com.bmf.infrastructure.dal.po.UserDomainPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDomainRepositoryImpl implements UserDomainRepository {

    @Autowired
    private UserDomainMapper userDomainMapper;

    @Override
    public UserDomain selectOne(UserDomain req) {
        UserDomainPO userDomainPO = POUtils.convert(req, UserDomainPO.class);
        return POUtils.convert(userDomainMapper.selectOne(userDomainPO), UserDomain.class);
    }

    @Override
    public boolean insert(UserDomain req) {
        UserDomainPO userDomainPO = POUtils.convert(req, UserDomainPO.class);
        return userDomainMapper.insert(userDomainPO) == 1;
    }

    @Override
    public boolean update(UserDomain req) {
        return false;
    }

    @Override
    public boolean delete(UserDomain req) {
        return false;
    }
}
