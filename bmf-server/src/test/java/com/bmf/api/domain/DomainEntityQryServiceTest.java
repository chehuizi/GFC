package com.bmf.api.domain;

import com.bmf.design.api.Result;
import com.bmf.design.api.domain.dto.DomainEntityQryReqDTO;
import com.bmf.design.api.domain.dto.DomainEntityRespDTO;
import com.bmf.design.api.domain.qry.DomainEntityQryService;
import com.bmf.design.base.tactics.entity.DomainEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainEntityQryServiceTest {

    @Autowired
    private DomainEntityQryService domainEntityQryService;

    @Test
    public void testDomainEntityQueryOne() {
        DomainEntityQryReqDTO domainEntityQryReqDTO = new DomainEntityQryReqDTO();
        DomainEntity domainEntity = new DomainEntity();
        domainEntity.setDomainCode(101);
        domainEntity.setEntityIdCode(10001);
        domainEntityQryReqDTO.setDomainEntity(domainEntity);
        domainEntityQryReqDTO.setIncludeAttr(true);
        domainEntityQryReqDTO.setIncludeVo(true);
        Result<DomainEntityRespDTO> result = domainEntityQryService.queryOne(domainEntityQryReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData().getEntityAttrList().size() == 3
                        && result.getData().getVoList().size() == 1);
    }
}

