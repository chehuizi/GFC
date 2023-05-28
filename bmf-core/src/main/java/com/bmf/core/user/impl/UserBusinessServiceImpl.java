package com.bmf.core.user.impl;

import com.bmf.base.user.UserBusiness;
import com.bmf.core.user.UserBusinessService;
import com.bmf.infrastructure.dal.UserBusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserBusinessServiceImpl implements UserBusinessService {

    @Autowired
    private UserBusinessRepository userBusinessRepository;

    @Override
    public Boolean addUserBusiness(UserBusiness userBusiness) {
        return userBusinessRepository.insert(userBusiness);
    }

    @Override
    public List<UserBusiness> queryUserBusiness(UserBusiness userBusiness) {
        return Arrays.asList(userBusinessRepository.selectOne(userBusiness));
    }
}
