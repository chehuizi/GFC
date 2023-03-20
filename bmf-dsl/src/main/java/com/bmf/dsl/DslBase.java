package com.bmf.dsl;

import com.bmf.base.BaseModel;
import lombok.Data;

import java.util.List;

/**
 * DSL基类
 */
@Data
public class DslBase extends BaseModel {

    /**
     * 领域编码
     * @see com.bmf.base.BusinessDomain
     */
    private Integer domainCode;
    /**
     * 名称（中文）
     */
    private String name;
    /**
     * 别名（英文）
     */
    private String alias;
    /**
     * 描述
     */
    private String desc;
    /**
     * 扩展列表
     */
    private List<DslExt> extList;
}
