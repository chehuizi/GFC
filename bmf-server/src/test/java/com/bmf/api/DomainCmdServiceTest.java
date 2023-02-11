package com.bmf.api;

import com.bmf.api.domain.DomainCmdService;
import com.bmf.api.domain.dto.DomainReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.AttrTypeEnum;
import com.bmf.base.enums.BusinessDomainLevelEnum;
import com.bmf.base.enums.BusinessDomainTypeEnum;
import com.bmf.base.tactics.entity.BusinessDomainEntity;
import com.bmf.common.enums.ResultCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainCmdServiceTest {

    @Autowired
    private DomainCmdService domainCmdService;

    @Test
    public void test_domain_create() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(50);
        businessDomain.setDomainName("仓库管理域");
        businessDomain.setDomainAlias("wms");
        businessDomain.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        businessDomain.setDomainLevel(BusinessDomainLevelEnum.Three.getValue());
        domainReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_domain_update() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(102);
        businessDomain.setDomainName("库存管理域");
        domainReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.update(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_domain_delete_1() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(10);
        businessDomain.setDomainAlias("wms");
        domainReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.delete(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_domain_delete_2() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(10);
        domainReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.delete(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_domain_add_entity() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(103);
        domainReqDTO.setBusinessDomain(businessDomain);
        BusinessDomainEntity domainEntity = new BusinessDomainEntity();
        domainEntity.setDomainCode(103);
        domainEntity.setEntityIdAlias("whSn");
        domainEntity.setEntityIdName("仓库编号");
        domainEntity.setEntityIdType(AttrTypeEnum.STRING.getType());
        domainEntity.setEntityDesc("仓库");
        domainReqDTO.setDomainEntity(domainEntity);
        Result<Boolean> result = domainCmdService.addEntity(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_del_entity() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomainEntity domainEntity = new BusinessDomainEntity();
        domainEntity.setDomainCode(103);
        domainEntity.setEntityIdCode(100006);
        domainReqDTO.setDomainEntity(domainEntity);
        Result<Boolean> result = domainCmdService.delEntity(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_add_vo() {
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
        Result<Boolean> result = domainCmdService.addValueObject(domainReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_domain_add_entity_rel_vo() {
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
        Result<Boolean> result = domainCmdService.addEntityRelVO(domainReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_domain_add_aggregate() {
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
        Result<Boolean> result = domainCmdService.addAggregate(domainReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_domain_add_service() {
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
        Result<Boolean> result = domainCmdService.addService(domainReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_domain_add_domain_event() {
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
        Result<Boolean> result = domainCmdService.addDomainEvent(domainReqDTO);
        System.out.println(result);
    }
}

