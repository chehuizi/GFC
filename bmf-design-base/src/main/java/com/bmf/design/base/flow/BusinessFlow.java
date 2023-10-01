package com.bmf.design.base.flow;

import com.bmf.design.base.BaseModel;
import lombok.Data;

/**
 * 业务流程
 */
@Data
public class BusinessFlow extends BaseModel {

    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 流程ID
     */
    private Integer flowId;
    /**
     * 流程名称（中文）
     */
    private String flowName;
    /**
     * 流程别名（英文）
     */
    private String flowAlias;
    /**
     * 角色ID
     */
    private Integer roleId;
}
