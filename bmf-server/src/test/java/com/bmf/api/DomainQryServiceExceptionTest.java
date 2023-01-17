package com.bmf.api;

import com.bmf.api.domain.DomainQryService;
import com.bmf.api.domain.dto.DomainReqDTO;
import com.bmf.api.domain.dto.DomainRespDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.common.enums.BizCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainQryServiceExceptionTest {

    @Autowired
    private DomainQryService domainQryService;

    @Test
    public void test_domain_query_one_exp_80001_1() {
        Result<DomainRespDTO> result = domainQryService.queryOne(null);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_query_one_exp_80001_2() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        domainReqDTO.setBusinessDomain(null);
        Result<DomainRespDTO> result = domainQryService.queryOne(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_query_one_exp_80001_3() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        domainReqDTO.setBusinessDomain(businessDomain);
        Result<DomainRespDTO> result = domainQryService.queryOne(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }
}

