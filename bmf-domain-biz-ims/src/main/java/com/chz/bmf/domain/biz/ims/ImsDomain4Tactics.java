package com.chz.bmf.domain.biz.ims;

import com.chz.bmf.domain.base.tactics.BusinessDomain4Tactics;
import com.chz.bmf.domain.base.tactics.entity.BusinessEntity4Domain;
import com.chz.bmf.domain.base.tactics.meta.BusinessDomainMeta;
import com.chz.bmf.domain.base.tactics.service.BusinessService4Domain;
import com.chz.bmf.domain.biz.ims.meta.ImsDomainMeta;

import java.util.List;

public class ImsDomain4Tactics extends BusinessDomain4Tactics {
    @Override
    public BusinessDomainMeta buildDomainMeta() {
        return new ImsDomainMeta();
    }

    @Override
    public List<BusinessEntity4Domain> buildEntityList() {
        return null;
    }

    @Override
    public List<BusinessService4Domain> buildServiceList() {
        return null;
    }
}
