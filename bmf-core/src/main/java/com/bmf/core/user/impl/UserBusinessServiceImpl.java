package com.bmf.core.user.impl;

import com.bmf.base.user.UserBusiness;
import com.bmf.core.user.UserBusinessService;
import com.bmf.infrastructure.dal.UserBusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessServiceImpl implements UserBusinessService {

    @Autowired
    private UserBusinessRepository userBusinessRepository;

    @Override
    public Boolean addUserBusiness(UserBusiness userBusiness) {
        return userBusinessRepository.insert(userBusiness);
    }
}
