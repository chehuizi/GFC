package com.bmf.base.strategy;

import com.bmf.base.BusinessDomain;
import lombok.Data;

/**
 * 业务域关系
 */
@Data
public class BusinessDomainRelationship {

    /**
     * 领域关系
     * @see com.bmf.base.enums.RelationshipEnum
     */
    private String relationship;
    /**
     * 领域A
     */
    private BusinessDomain domainA;
    /**
     * 领域B
     */
    private BusinessDomain domainB;

    @Override
    public String toString() {
        return "{" +
                "\"relationship\": \"" + relationship + "\"" +
                ", \"domainA\": \"" + domainA.getDomainName() + "\"" +
                ", \"domainB\": \"" + domainB.getDomainName() + "\"" +
                '}';
    }
}
