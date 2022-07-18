package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class BusinessDomainEntityPO extends BasePO {

    /**
     * 实体唯一ID编码
     */
    private Integer entityIdCode;
    /**
     * 实体唯一ID名称
     */
    private String entityIdName;
    /**
     * 实体唯一ID类型
     * @see com.bmf.base.enums.AttrTypeEnum
     */
    private String entityIdType;

}
