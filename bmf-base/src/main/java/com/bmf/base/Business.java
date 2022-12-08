package com.bmf.base;

import com.bmf.base.enums.BusinessPrefixEnum;
import lombok.Data;

import java.util.List;

/**
 * 业务
 */
@Data
public class Business extends BaseModel {

    /**
     * 业务前缀
     * @see com.bmf.base.enums.BusinessPrefixEnum
     */
    private String businessPrefix;
    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 业务名称（中文）
     */
    private String businessName;
    /**
     * 业务别名（英文）
     */
    private String businessAlias;
    /**
     * 业务描述
     */
    private String businessDesc;
    /**
     * 业务域列表
     * @see BusinessDomain
     */
    private List<BusinessDomain> businessDomainList;
    /**
     * 业务域关系列表
     * @see BusinessDomainRelation
     */
    private List<BusinessDomainRelation> businessDomainRelationList;

    public Business() {
        this.setBusinessPrefix(BusinessPrefixEnum.B.getPrefix());
    }
}
