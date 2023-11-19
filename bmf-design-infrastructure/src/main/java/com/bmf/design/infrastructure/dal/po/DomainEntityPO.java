package com.bmf.design.infrastructure.dal.po;

import com.bmf.design.model.enums.AttrTypeEnum;
import lombok.Data;

@Data
public class DomainEntityPO extends BasePO {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 实体唯一ID编码
     */
    private Integer entityIdCode;
    /**
     * 实体唯一ID别名（英文）
     */
    private String entityIdAlias;
    /**
     * 实体唯一ID名称（中文）
     */
    private String entityIdName;
    /**
     * 实体唯一ID类型
     * @see AttrTypeEnum
     */
    private String entityIdType;
    /**
     * 实体描述
     */
    private String entityDesc;
}
