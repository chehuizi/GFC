package com.bmf.base.dsl;

import com.bmf.base.BaseModel;
import lombok.Data;

import java.util.List;

/**
 * DSL基类
 */
@Data
public class BusinessDslBase extends BaseModel {

    /**
     * 领域编码
     * @see com.bmf.base.BusinessDomain
     */
    private Integer domainCode;
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
