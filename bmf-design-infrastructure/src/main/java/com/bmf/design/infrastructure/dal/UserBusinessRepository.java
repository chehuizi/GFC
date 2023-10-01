package com.bmf.design.infrastructure.dal;

import com.bmf.design.base.user.UserBusiness;

import java.util.List;

public interface UserBusinessRepository extends BaseRepository<UserBusiness> {

    /**
     * 根据用户下的业务
     * @param userId
     * @return
     */
    List<UserBusiness> selectByUser(Integer userId);
}
