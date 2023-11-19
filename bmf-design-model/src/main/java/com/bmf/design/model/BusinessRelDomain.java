package com.bmf.design.model;

import com.bmf.common.model.BaseModel;
import com.bmf.design.model.view.DomainPosition;
import lombok.Data;

@Data
public class BusinessRelDomain extends BaseModel {

    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 位置（JSON格式存储）
     * @see DomainPosition
     */
    private String domainPosition;
}
