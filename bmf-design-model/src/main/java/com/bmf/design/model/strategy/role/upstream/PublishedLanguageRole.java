package com.bmf.design.model.strategy.role.upstream;

import com.bmf.design.model.Domain;
import com.bmf.design.model.enums.RelationshipRoleEnum;

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
