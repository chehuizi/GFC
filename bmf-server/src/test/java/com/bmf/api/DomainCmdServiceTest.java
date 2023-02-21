package com.bmf.api;

import com.bmf.api.domain.DomainCmdService;
import com.bmf.api.domain.dto.DomainReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.AttrTypeEnum;
import com.bmf.base.enums.BusinessDomainLevelEnum;
import com.bmf.base.enums.BusinessDomainTypeEnum;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.service.DomainService;
import com.bmf.base.tactics.valueobject.DomainValueObject;
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
    public void test_domain_delete() {
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
        DomainEntity domainEntity = new DomainEntity();
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
        DomainEntity domainEntity = new DomainEntity();
        domainEntity.setDomainCode(103);
        domainEntity.setEntityIdCode(100009);
        domainReqDTO.setDomainEntity(domainEntity);
        Result<Boolean> result = domainCmdService.delEntity(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_add_service() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(103);
        domainReqDTO.setBusinessDomain(businessDomain);
        DomainService domainService = new DomainService();
        domainService.setDomainCode(103);
        domainService.setServiceAlias("outbound_service");
        domainService.setServiceName("出库服务");
        domainService.setServiceDesc("支持存货和固资出库服务");
        domainReqDTO.setDomainService(domainService);
        Result<Boolean> result = domainCmdService.addService(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_del_service() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        DomainService domainService = new DomainService();
        domainService.setDomainCode(103);
        domainService.setServiceCode(100001);
        domainReqDTO.setDomainService(domainService);
        Result<Boolean> result = domainCmdService.delService(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_add_vo() {
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(103);
        domainReqDTO.setBusinessDomain(businessDomain);
        DomainValueObject valueObject = new DomainValueObject();
        valueObject.setDomainCode(103);
        valueObject.setVoAlias("zone");
        valueObject.setVoName("行政区划");
        valueObject.setVoDesc("国家行政区划（国标）");
        domainReqDTO.setDomainValueObject(valueObject);
        Result<Boolean> result = domainCmdService.addValueObject(domainReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
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
        DomainEntity domainEntity = new DomainEntity();
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
        DomainEntity domainEntity = new DomainEntity();
        domainEntity.setEntityIdCode(1011);
        domainEntity.setEntityIdName("test");
        domainEntity.setEntityIdType(AttrTypeEnum.STRING.getType());
        domainReqDTO.setDomainEntity(domainEntity);
        Result<Boolean> result = domainCmdService.addAggregate(domainReqDTO);
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
        DomainEntity domainEntity = new DomainEntity();
        domainEntity.setEntityIdCode(1011);
        domainEntity.setEntityIdName("test");
        domainEntity.setEntityIdType(AttrTypeEnum.STRING.getType());
        domainReqDTO.setDomainEntity(domainEntity);
        Result<Boolean> result = domainCmdService.addDomainEvent(domainReqDTO);
        System.out.println(result);
    }
}

