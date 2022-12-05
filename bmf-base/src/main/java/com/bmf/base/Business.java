package com.bmf.base;

import lombok.Data;

import java.util.List;

/**
 * 业务
 */
@Data
public class Business extends BaseModel {

    /**
     * 业务编码
     */
    private Integer businessCode;

    /**
     * 业务名称
     */
    private String businessName;

    /**
     * 业务域列表
     */
    private List<BusinessDomain> businessDomainList;

    /**
     * 业务域关系列表
     */
    private List<BusinessDomainRelation> businessDomainRelationList;

}
