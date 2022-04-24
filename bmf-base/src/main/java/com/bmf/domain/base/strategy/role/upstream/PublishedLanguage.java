package com.bmf.domain.base.strategy.role.upstream;

import com.bmf.domain.base.BusinessDomain;
import com.bmf.domain.base.enums.RelationshipRoleEnum;

/**
 * 发布语言
 */
public class PublishedLanguage extends UpstreamRole {

    public PublishedLanguage() {
        super.setRole(RelationshipRoleEnum.PL.getRole());
    }

    public PublishedLanguage(BusinessDomain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.PL.getRole());
    }
}
