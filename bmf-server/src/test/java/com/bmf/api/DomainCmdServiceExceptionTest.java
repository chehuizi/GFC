package com.bmf.api;

import com.bmf.api.domain.DomainCmdService;
import com.bmf.api.domain.DomainReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.AttrTypeEnum;
import com.bmf.base.enums.BusinessDomainLevelEnum;
import com.bmf.base.enums.BusinessDomainTypeEnum;
import com.bmf.base.tactics.entity.BusinessDomainEntity;
import com.bmf.common.enums.BizCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainCmdServiceExceptionTest {

    @Autowired
    private DomainCmdService domainCmdService;

    @Test
    public void test_domain_create_exp_80001_1() {
        Result<Boolean> result = domainCmdService.create(null);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_2() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        domainReqDTO.setBusinessDomain(null);
        Result<Boolean> result = domainCmdService.create(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }
}

