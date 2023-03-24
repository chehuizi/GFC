package com.bmf.base.application;

import com.bmf.base.BaseModel;
import lombok.Data;

/**
 * 业务API
 */
@Data
public class BusinessApi extends BaseModel {

    /**
     * API编号
     */
    private Integer apiNo;
    /**
     * API名称
     */
    private String apiName;
    /**
     * API路径
     */
    private String apiPath;
    /**
     * API描述
     */
    private String apiDesc;
}
