package com.bmf.design.base.strategy.role.upstream;

import com.bmf.design.base.Domain;
import com.bmf.design.base.enums.RelationshipRoleEnum;

/**
 * 发布语言
 */
public class PublishedLanguageRole extends UpstreamRole {

    public PublishedLanguageRole() {
        super.setRole(RelationshipRoleEnum.PL.getRole());
    }

    public PublishedLanguageRole(Domain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.PL.getRole());
    }
}
