package com.bmf.infrastructure.dal;

import com.bmf.api.domain.DomainReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.BusinessDomainLevelEnum;
import com.bmf.base.enums.BusinessDomainTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainRepositoryTest {

    @Autowired
    private DomainRepository domainRepository;

    @Test
    public void test_domain_insert() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("test");
        businessDomain.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        businessDomain.setDomainLevel(BusinessDomainLevelEnum.Three.getValue());
        domainReqDTO.setBusinessDomain(businessDomain);
        boolean result = domainRepository.insert(domainReqDTO);
        System.out.println(result);
    }

}

