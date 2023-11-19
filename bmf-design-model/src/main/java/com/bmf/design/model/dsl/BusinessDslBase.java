package com.bmf.design.model.dsl;

import com.bmf.common.model.BaseModel;
import com.bmf.design.model.Domain;
import lombok.Data;

import java.util.List;

/**
 * DSL基类
 */
@Data
public class BusinessDslBase extends BaseModel {

    /**
     * 领域编码
     * @see Domain
     */
    private Integer domainCode;
    /**
     * 术语编码
     */
    private Integer dslCode;
    /**
     * 名称（中文）
     */
    private String dslName;
    /**
     * 别名（英文）
     */
    private String dslAlias;
    /**
     * 描述
     */
    private String dslDesc;
    /**
     * 扩展列表
     */
    private List<BusinessDslExt> dslExtList;
}
