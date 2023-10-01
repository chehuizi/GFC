package com.bmf.design.base.user;

import com.bmf.design.base.BaseModel;
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
