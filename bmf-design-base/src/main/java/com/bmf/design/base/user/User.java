package com.bmf.design.base.user;

import com.bmf.design.base.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 */
@Data
@NoArgsConstructor
public class User extends BaseModel {

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

    public User(Integer userId) {
        this.userId = userId;
    }
}
