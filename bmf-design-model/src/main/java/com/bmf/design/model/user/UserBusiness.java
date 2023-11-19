package com.bmf.design.model.user;

import com.bmf.common.model.BaseModel;
import lombok.Data;

/**
 * 用户业务
 */
@Data
public class UserBusiness extends BaseModel {

    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 业务名称
     */
    private String businessName;
}
