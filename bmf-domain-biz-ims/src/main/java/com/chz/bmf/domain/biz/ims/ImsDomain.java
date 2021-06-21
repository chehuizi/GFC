package com.chz.bmf.domain.biz.ims;

import com.chz.bmf.domain.base.BusinessDomain;
import com.chz.bmf.domain.base.entity.BusinessEntity4Domain;
import com.chz.bmf.domain.base.meta.BusinessDomainMeta;
import com.chz.bmf.domain.base.service.BusinessService4Domain;
import com.chz.bmf.domain.biz.ims.meta.ImsDomainMeta;

import java.util.List;

public class ImsDomain extends BusinessDomain {
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
