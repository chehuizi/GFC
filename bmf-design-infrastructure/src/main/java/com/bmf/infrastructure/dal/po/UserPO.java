package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class UserPO extends BasePO {

    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
}
