package com.bmf.design.core.user.impl;

import com.bmf.design.base.user.UserDomain;
import com.bmf.design.core.user.UserDomainService;
import com.bmf.design.infrastructure.dal.UserDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDomainServiceImpl implements UserDomainService {

    @Autowired
    private UserDomainRepository userDomainRepository;

    @Override
    public Boolean addUserDomain(UserDomain userDomain) {
        return userDomainRepository.insert(userDomain);
    }
}
