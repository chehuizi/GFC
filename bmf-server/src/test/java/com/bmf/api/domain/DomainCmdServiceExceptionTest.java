package com.bmf.api.domain;

import com.bmf.design.api.Result;
import com.bmf.design.api.domain.cmd.DomainCmdService;
import com.bmf.design.api.domain.dto.DomainCmdReqDTO;
import com.bmf.design.base.Domain;
import com.bmf.design.base.enums.DomainLevelEnum;
import com.bmf.design.base.enums.DomainTypeEnum;
import com.bmf.design.common.enums.BizCodeEnum;
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
        domainCmdReqDTO.setDomain(null);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_3() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        Domain domain = new Domain();
        domain.setDomainName("");
        domain.setDomainCode(10);
        domain.setDomainAlias("wms");
        domain.setDomainLevel(DomainLevelEnum.THREE.getValue());
        domain.setDomainType(DomainTypeEnum.CORE.getType());
        domainCmdReqDTO.setDomain(domain);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_4() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        Domain domain = new Domain();
        domain.setDomainName("仓库管理系统");
        domain.setDomainCode(null);
        domain.setDomainAlias("wms");
        domain.setDomainLevel(DomainLevelEnum.THREE.getValue());
        domain.setDomainType(DomainTypeEnum.CORE.getType());
        domainCmdReqDTO.setDomain(domain);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_5() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        Domain domain = new Domain();
        domain.setDomainName("仓库管理系统");
        domain.setDomainCode(10);
        domain.setDomainAlias("");
        domain.setDomainLevel(DomainLevelEnum.THREE.getValue());
        domain.setDomainType(DomainTypeEnum.CORE.getType());
        domainCmdReqDTO.setDomain(domain);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_6() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        Domain domain = new Domain();
        domain.setDomainName("仓库管理系统");
        domain.setDomainCode(10);
        domain.setDomainAlias("wms");
        domain.setDomainLevel(DomainLevelEnum.THREE.getValue());
        domain.setDomainType("");
        domainCmdReqDTO.setDomain(domain);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_7() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        Domain domain = new Domain();
        domain.setDomainName("仓库管理系统");
        domain.setDomainCode(10);
        domain.setDomainAlias("wms");
        domain.setDomainLevel(DomainLevelEnum.THREE.getValue());
        domain.setDomainType("test");
        domainCmdReqDTO.setDomain(domain);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_80001_8() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        Domain domain = new Domain();
        domain.setDomainName("仓库管理系统");
        domain.setDomainCode(10);
        domain.setDomainAlias("wms");
        domain.setDomainLevel(0);
        domain.setDomainType(DomainTypeEnum.CORE.getType());
        domainCmdReqDTO.setDomain(domain);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_create_exp_100004() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        Domain domain = new Domain();
        domain.setDomainCode(10);
        domain.setDomainName("仓库管理系统");
        domain.setDomainAlias("wms");
        domain.setDomainType(DomainTypeEnum.CORE.getType());
        domain.setDomainLevel(DomainLevelEnum.THREE.getValue());
        domainCmdReqDTO.setDomain(domain);
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
        domainCmdReqDTO.setDomain(null);
        Result<Boolean> result = domainCmdService.update(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_domain_update_exp_80001_3() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        Domain domain = new Domain();
        domain.setDomainName("仓库管理系统");
        domainCmdReqDTO.setDomain(domain);
        Result<Boolean> result = domainCmdService.update(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }
}

