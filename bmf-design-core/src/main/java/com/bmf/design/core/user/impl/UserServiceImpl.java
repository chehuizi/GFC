package com.bmf.design.core.user.impl;

import com.bmf.design.model.user.User;
import com.bmf.design.core.user.UserService;
import com.bmf.design.infrastructure.dal.UserRepository;
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
