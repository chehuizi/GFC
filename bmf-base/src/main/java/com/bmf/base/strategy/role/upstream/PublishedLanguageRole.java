package com.bmf.base.strategy.role.upstream;

import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.RelationshipRoleEnum;

/**
 * 发布语言
 */
public class PublishedLanguageRole extends UpstreamRole {

    public PublishedLanguageRole() {
        super.setRole(RelationshipRoleEnum.PL.getRole());
    }

    public PublishedLanguageRole(BusinessDomain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.PL.getRole());
    }
}
