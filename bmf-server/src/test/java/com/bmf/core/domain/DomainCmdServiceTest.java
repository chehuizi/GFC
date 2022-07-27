package com.bmf.core.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.DomainCmdService;
import com.bmf.api.domain.DomainReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.AttrTypeEnum;
import com.bmf.base.enums.BusinessDomainLevelEnum;
import com.bmf.base.enums.BusinessDomainTypeEnum;
import com.bmf.base.tactics.entity.BusinessDomainEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainCmdServiceTest {

    @Autowired
    private DomainCmdService domainCmdService;

    @Test
    public void test_create_domain() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(12);
        businessDomain.setDomainName("test");
        businessDomain.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        businessDomain.setDomainLevel(BusinessDomainLevelEnum.Three.getValue());
        domainReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_add_entity() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(14);
        businessDomain.setDomainName("test");
        businessDomain.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        businessDomain.setDomainLevel(BusinessDomainLevelEnum.Three.getValue());
        domainReqDTO.setBusinessDomain(businessDomain);
        BusinessDomainEntity domainEntity = new BusinessDomainEntity();
        domainEntity.setEntityIdCode(1011);
        domainEntity.setEntityIdName("test");
        domainEntity.setEntityIdType(AttrTypeEnum.STRING.getType());
        domainReqDTO.setDomainEntity(domainEntity);
        Result<Boolean> result = domainCmdService.addEntity(domainReqDTO);
        System.out.println(result);
    }
}

