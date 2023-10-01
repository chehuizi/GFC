package com.bmf.design.core.user;

import com.bmf.design.base.user.UserBusiness;

import java.util.List;

/**
 * 用户业务服务
 */
public interface UserBusinessService {

    /**
     * 用户添加业务
     * @param userBusiness
     * @return
     */
    Boolean addUserBusiness(UserBusiness userBusiness);

    List<UserBusiness> queryUserBusiness(UserBusiness userBusiness);
}
