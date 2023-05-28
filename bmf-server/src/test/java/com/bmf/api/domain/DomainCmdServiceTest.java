package com.bmf.api.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.cmd.DomainCmdService;
import com.bmf.api.domain.dto.DomainCmdReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.dsl.BusinessDslBase;
import com.bmf.base.enums.AttrTypeEnum;
import com.bmf.base.enums.BusinessDomainLevelEnum;
import com.bmf.base.enums.BusinessDomainTypeEnum;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.event.DomainEvent;
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
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName("库存域");
        businessDomain.setDomainAlias("ims");
        businessDomain.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        businessDomain.setDomainLevel(BusinessDomainLevelEnum.Three.getValue());
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.create(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_domain_update() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(104);
        businessDomain.setDomainName("库存域");
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.update(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_domain_delete() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(10);
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        Result<Boolean> result = domainCmdService.delete(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_domain_add_dsl() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(103);
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        BusinessDslBase businessDslBase = new BusinessDslBase();
        businessDslBase.setDomainCode(103);
        businessDslBase.setDslName("批次管理");
        businessDslBase.setDslAlias("Batch Management");
        businessDslBase.setDslDesc("批次管理");
        domainCmdReqDTO.setDslBase(businessDslBase);
        Result<Boolean> result = domainCmdService.addDsl(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_del_dsl() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(101);
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        BusinessDslBase businessDslBase = new BusinessDslBase();
        businessDslBase.setDomainCode(101);
        businessDslBase.setDslCode(1000008);
        domainCmdReqDTO.setDslBase(businessDslBase);
        Result<Boolean> result = domainCmdService.delDsl(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_add_entity() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(103);
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        DomainEntity domainEntity = new DomainEntity();
        domainEntity.setDomainCode(103);
        domainEntity.setEntityIdAlias("whSn");
        domainEntity.setEntityIdName("仓库编号");
        domainEntity.setEntityIdType(AttrTypeEnum.STRING.getType());
        domainEntity.setEntityDesc("仓库");
        domainCmdReqDTO.setDomainEntity(domainEntity);
        Result<Boolean> result = domainCmdService.addEntity(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_del_entity() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        DomainEntity domainEntity = new DomainEntity();
        domainEntity.setDomainCode(103);
        domainEntity.setEntityIdCode(100009);
        domainCmdReqDTO.setDomainEntity(domainEntity);
        Result<Boolean> result = domainCmdService.delEntity(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_add_service() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(103);
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        DomainService domainService = new DomainService();
        domainService.setDomainCode(103);
        domainService.setServiceAlias("apply_inbound_service");
        domainService.setServiceName("预约入库服务");
        domainService.setServiceDesc("支持存货和固资预约入库服务");
        domainCmdReqDTO.setDomainService(domainService);
        Result<Boolean> result = domainCmdService.addService(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_del_service() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        DomainService domainService = new DomainService();
        domainService.setDomainCode(103);
        domainService.setServiceCode(100001);
        domainCmdReqDTO.setDomainService(domainService);
        Result<Boolean> result = domainCmdService.delService(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_add_vo() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(103);
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        DomainValueObject valueObject = new DomainValueObject();
        valueObject.setDomainCode(103);
        valueObject.setVoAlias("zone");
        valueObject.setVoName("行政区划");
        valueObject.setVoDesc("国家行政区划（国标）");
        domainCmdReqDTO.setDomainValueObject(valueObject);
        Result<Boolean> result = domainCmdService.addValueObject(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_del_vo() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        DomainValueObject valueObject = new DomainValueObject();
        valueObject.setDomainCode(103);
        valueObject.setVoCode(102);
        domainCmdReqDTO.setDomainValueObject(valueObject);
        Result<Boolean> result = domainCmdService.delValueObject(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_add_event() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(103);
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        DomainEvent domainEvent = new DomainEvent();
        domainEvent.setDomainCode(103);
        domainEvent.setEventAlias("outbound_success_event");
        domainEvent.setEventName("出库成功事件");
        domainEvent.setEventDesc("出库单成功关闭");
        domainCmdReqDTO.setDomainEvent(domainEvent);
        Result<Boolean> result = domainCmdService.addEvent(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_del_event() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        DomainEvent domainEvent = new DomainEvent();
        domainEvent.setDomainCode(103);
        domainEvent.setEventCode(103);
        domainCmdReqDTO.setDomainEvent(domainEvent);
        Result<Boolean> result = domainCmdService.delEvent(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_add_entity_rel_vo() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        DomainEntity domainEntity = new DomainEntity();
        domainCmdReqDTO.setDomainEntity(domainEntity);
        domainEntity.setDomainCode(103);
        domainEntity.setEntityIdCode(10001);
        DomainValueObject domainValueObject = new DomainValueObject();
        domainValueObject.setDomainCode(103);
        domainValueObject.setVoCode(10002);
        domainCmdReqDTO.setDomainValueObject(domainValueObject);
        Result<Boolean> result = domainCmdService.addEntityRelVO(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_del_entity_rel_vo() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        DomainEntity domainEntity = new DomainEntity();
        domainCmdReqDTO.setDomainEntity(domainEntity);
        domainEntity.setDomainCode(103);
        domainEntity.setEntityIdCode(100010);
        DomainValueObject domainValueObject = new DomainValueObject();
        domainValueObject.setDomainCode(103);
        domainValueObject.setVoCode(103);
        domainCmdReqDTO.setDomainValueObject(domainValueObject);
        Result<Boolean> result = domainCmdService.delEntityRelVO(domainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void test_domain_add_aggregate() {
        DomainCmdReqDTO domainCmdReqDTO = new DomainCmdReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(14);
        businessDomain.setDomainName("test");
        businessDomain.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        businessDomain.setDomainLevel(BusinessDomainLevelEnum.Three.getValue());
        domainCmdReqDTO.setBusinessDomain(businessDomain);
        DomainEntity domainEntity = new DomainEntity();
        domainEntity.setEntityIdCode(1011);
        domainEntity.setEntityIdName("test");
        domainEntity.setEntityIdType(AttrTypeEnum.STRING.getType());
        domainCmdReqDTO.setDomainEntity(domainEntity);
        Result<Boolean> result = domainCmdService.addAggregate(domainCmdReqDTO);
        System.out.println(result);
    }

}

