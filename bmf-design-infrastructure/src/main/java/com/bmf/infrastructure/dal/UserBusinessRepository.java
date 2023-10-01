package com.bmf.infrastructure.dal;

import com.bmf.base.user.UserBusiness;

import java.util.List;

public interface UserBusinessRepository extends BaseRepository<UserBusiness> {

    /**
     * 根据用户下的业务
     * @param userId
     * @return
     */
    List<UserBusiness> selectByUser(Integer userId);
}
