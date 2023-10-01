package com.bmf.design.api.domain.dto;

import com.bmf.design.api.ReqDTO;
import com.bmf.design.base.dsl.BusinessDslBase;
import com.bmf.design.base.dsl.BusinessDslExt;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * DSL CMD请求参数
 */
@Data
public class DslCmdReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = -9005752590719201124L;

    /**
     * DSL基础信息
     */
    private BusinessDslBase dslBase;
    /**
     * DSL扩展属性列表
     */
    private List<BusinessDslExt> dslExtList;
    /**
     * DSL扩展属性
     */
    private BusinessDslExt dslExt;
}
