package com.bmf.core.user;

import com.bmf.base.user.User;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    Boolean addUser(User user);

    /**
     * 查询用户
     * @param user
     * @return
     */
    User queryUser(User user);
}
