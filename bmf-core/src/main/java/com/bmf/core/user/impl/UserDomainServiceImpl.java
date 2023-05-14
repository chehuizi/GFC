package com.bmf.core.user.impl;

import com.bmf.base.user.UserDomain;
import com.bmf.core.user.UserDomainService;
import com.bmf.infrastructure.dal.UserDomainRepository;
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
