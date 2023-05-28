package com.bmf.core.user.impl;

import com.bmf.base.user.User;
import com.bmf.core.user.UserService;
import com.bmf.infrastructure.dal.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean addUser(User user) {
        return userRepository.insert(user);
    }

    @Override
    public User queryUser(User user) {
        return userRepository.selectOne(user);
    }
}
