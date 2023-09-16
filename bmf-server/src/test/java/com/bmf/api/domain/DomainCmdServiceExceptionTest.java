package com.bmf.api.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.cmd.DomainCmdService;
import com.bmf.api.domain.dto.DomainCmdReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.DomainLevelEnum;
import com.bmf.base.enums.DomainTypeEnum;
import com.bmf.common.enums.BizCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        domainCmdReqDTO.setBusinessDomain(null);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_3() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("");
        businessDomain.setDomainCode(10);
        businessDomain.setDomainAlias("wms");
        businessDomain.setDomainLevel(DomainLevelEnum.THREE.getValue());
        businessDomain.setDomainType(DomainTypeEnum.CORE.getType());
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_4() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("仓库管理系统");
        businessDomain.setDomainCode(null);
        businessDomain.setDomainAlias("wms");
        businessDomain.setDomainLevel(DomainLevelEnum.THREE.getValue());
        businessDomain.setDomainType(DomainTypeEnum.CORE.getType());
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_5() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("仓库管理系统");
        businessDomain.setDomainCode(10);
        businessDomain.setDomainAlias("");
        businessDomain.setDomainLevel(DomainLevelEnum.THREE.getValue());
        businessDomain.setDomainType(DomainTypeEnum.CORE.getType());
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_6() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("仓库管理系统");
        businessDomain.setDomainCode(10);
        businessDomain.setDomainAlias("wms");
        businessDomain.setDomainLevel(DomainLevelEnum.THREE.getValue());
        businessDomain.setDomainType("");
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_7() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("仓库管理系统");
        businessDomain.setDomainCode(10);
        businessDomain.setDomainAlias("wms");
        businessDomain.setDomainLevel(DomainLevelEnum.THREE.getValue());
        businessDomain.setDomainType("test");
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_8() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("仓库管理系统");
        businessDomain.setDomainCode(10);
        businessDomain.setDomainAlias("wms");
        businessDomain.setDomainLevel(0);
        businessDomain.setDomainType(DomainTypeEnum.CORE.getType());
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_100004() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(10);
        businessDomain.setDomainName("仓库管理系统");
        businessDomain.setDomainAlias("wms");
        businessDomain.setDomainType(DomainTypeEnum.CORE.getType());
        businessDomain.setDomainLevel(DomainLevelEnum.THREE.getValue());
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.DOMAIN_IS_EXISTED.getCode() == result.getCode());
    }

    @Test
    public void test_domain_update_exp_80001_1() {
        Result<Boolean> result = domainCmdService.update(null);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_update_exp_80001_2() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        domainCmdReqDTO.setBusinessDomain(null);
        Result<Boolean> result = domainCmdService.update(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_update_exp_80001_3() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("仓库管理系统");
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.update(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }
}

