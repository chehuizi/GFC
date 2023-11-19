package com.bmf.design.model.user;

import com.bmf.common.model.BaseModel;
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
