package com.chz.bmf.meta;

import com.chz.bmf.common.BusinessDomainLevelEnum;
import com.chz.bmf.common.BusinessDomainNameEnum;
import lombok.Data;

/**
 * 业务领域元数据
 */
@Data
public class BusinessDomainMeta {

    /**
     * 等级
     */
    private BusinessDomainLevelEnum level;
    /**
     * 名称
     */
    private BusinessDomainNameEnum name;
}
