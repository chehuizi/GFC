package com.bmf.base.user;

import com.bmf.base.BaseModel;
import lombok.Data;

/**
 * 用户领域
 */
@Data
public class UserDomain extends BaseModel {

    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 领域编码
     */
    private Integer domainCode;
}
