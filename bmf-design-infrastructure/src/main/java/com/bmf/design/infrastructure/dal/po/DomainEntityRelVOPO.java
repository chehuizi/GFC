package com.bmf.design.infrastructure.dal.po;

import lombok.Data;

@Data
public class DomainEntityRelVOPO extends BasePO {

    /**
     * 实体唯一ID编码
     */
    private Integer entityIdCode;
    /**
     * 值对象编码
     */
    private Integer voCode;

}
