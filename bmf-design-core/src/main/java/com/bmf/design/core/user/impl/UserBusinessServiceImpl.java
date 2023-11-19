package com.bmf.design.core.user.impl;

import com.bmf.design.model.user.UserBusiness;
import com.bmf.design.core.user.UserBusinessService;
import com.bmf.design.infrastructure.dal.UserBusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userBusinessRepository.selectByUser(userBusiness.getUserId());
    }
}
