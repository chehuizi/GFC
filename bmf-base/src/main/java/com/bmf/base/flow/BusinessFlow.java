package com.bmf.base.flow;

import com.bmf.base.BaseModel;
import lombok.Data;

/**
 * 业务流程
 */
@Data
public class BusinessFlow extends BaseModel {

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
}
