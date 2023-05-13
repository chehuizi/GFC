package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class UserBusinessPO extends BasePO {

    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 业务编码
     */
    private Integer businessCode;
}
