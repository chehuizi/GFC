package com.bmf.base.strategy.role.upstream;

import com.bmf.base.Domain;
import com.bmf.base.enums.RelationshipRoleEnum;

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
