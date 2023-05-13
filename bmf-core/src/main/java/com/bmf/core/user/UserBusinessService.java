package com.bmf.core.user;

import com.bmf.base.user.UserBusiness;

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
}
