package com.chz.bmf.domain.biz.ims;

import com.chz.bmf.domain.BusinessDomain;
import com.chz.bmf.domain.biz.ims.meta.ImsDomainMeta;
import com.chz.bmf.domain.common.BusinessDomainLevelEnum;
import com.chz.bmf.domain.common.BusinessDomainNameEnum;
import com.chz.bmf.domain.entity.BusinessEntity4Domain;
import com.chz.bmf.domain.service.BusinessService4Domain;

import java.util.ArrayList;
import java.util.List;

public class ImsDomain extends BusinessDomain {

    @Override
    public void buildDomain() {
        ImsDomain imsDomain = new ImsDomain();

        imsDomain.setMeta(new ImsDomainMeta(BusinessDomainLevelEnum.TWO, BusinessDomainNameEnum.INVENTORY_MANAGEMENT_SERVICE));

        List<BusinessEntity4Domain> businessEntityList = new ArrayList<>();
        imsDomain.setEntityList(businessEntityList);

        List<BusinessService4Domain> businessServiceList = new ArrayList<>();
        imsDomain.setServiceList(businessServiceList);
    }
}
