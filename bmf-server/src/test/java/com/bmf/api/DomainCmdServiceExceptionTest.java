package com.bmf.api;

import com.bmf.api.domain.DomainCmdService;
import com.bmf.api.domain.DomainReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.BusinessDomainLevelEnum;
import com.bmf.base.enums.BusinessDomainTypeEnum;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.enums.ResultCodeEnum;
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

    @Test
    public void test_domain_create_exp_80001_3() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("");
        businessDomain.setDomainCode(10);
        businessDomain.setDomainAlias("wms");
        businessDomain.setDomainLevel(BusinessDomainLevelEnum.Three.getValue());
        businessDomain.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        domainReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_4() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("仓库管理系统");
        businessDomain.setDomainCode(null);
        businessDomain.setDomainAlias("wms");
        businessDomain.setDomainLevel(BusinessDomainLevelEnum.Three.getValue());
        businessDomain.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        domainReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_5() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("仓库管理系统");
        businessDomain.setDomainCode(10);
        businessDomain.setDomainAlias("");
        businessDomain.setDomainLevel(BusinessDomainLevelEnum.Three.getValue());
        businessDomain.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        domainReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_6() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("仓库管理系统");
        businessDomain.setDomainCode(10);
        businessDomain.setDomainAlias("wms");
        businessDomain.setDomainLevel(BusinessDomainLevelEnum.Three.getValue());
        businessDomain.setDomainType("");
        domainReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_7() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("仓库管理系统");
        businessDomain.setDomainCode(10);
        businessDomain.setDomainAlias("wms");
        businessDomain.setDomainLevel(BusinessDomainLevelEnum.Three.getValue());
        businessDomain.setDomainType("test");
        domainReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_8() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("仓库管理系统");
        businessDomain.setDomainCode(10);
        businessDomain.setDomainAlias("wms");
        businessDomain.setDomainLevel(0);
        businessDomain.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        domainReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_100004() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(10);
        businessDomain.setDomainName("仓库管理系统");
        businessDomain.setDomainAlias("wms");
        businessDomain.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        businessDomain.setDomainLevel(BusinessDomainLevelEnum.Three.getValue());
        domainReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.DOMAIN_IS_EXISTED.getCode() == result.getCode());
    }
}

