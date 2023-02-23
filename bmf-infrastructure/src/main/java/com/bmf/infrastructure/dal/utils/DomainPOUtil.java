package com.bmf.infrastructure.dal.utils;

import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.entity.DomainEntityAttr;
import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.base.tactics.service.DomainService;
import com.bmf.base.tactics.service.DomainServiceAttr;
import com.bmf.base.tactics.valueobject.DomainValueObject;
import com.bmf.base.tactics.valueobject.DomainValueObjectAttr;
import com.bmf.infrastructure.dal.po.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PO工具类
 */
public class DomainPOUtil {

    /**
     * 转换对象
     * @param businessDomain
     * @return
     */
    public static DomainPO convert(BusinessDomain businessDomain) {
        if (Objects.isNull(businessDomain)) {
            return null;
        }
        DomainPO domainPO = new DomainPO();
        domainPO.setDomainCode(businessDomain.getDomainCode());
        domainPO.setDomainName(businessDomain.getDomainName());
        domainPO.setDomainAlias(businessDomain.getDomainAlias());
        domainPO.setDomainType(businessDomain.getDomainType());
        domainPO.setDomainLevel(businessDomain.getDomainLevel());
        return domainPO;
    }

    /**
     * 转换对象
     * @param domainPO
     * @return
     */
    public static BusinessDomain convert(DomainPO domainPO) {
        if (Objects.isNull(domainPO)) {
            return null;
        }
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(domainPO.getDomainCode());
        businessDomain.setDomainName(domainPO.getDomainName());
        businessDomain.setDomainAlias(domainPO.getDomainAlias());
        businessDomain.setDomainType(domainPO.getDomainType());
        businessDomain.setDomainLevel(domainPO.getDomainLevel());
        return businessDomain;
    }

    /**
     * 转换对象
     * @param domainPOList
     * @return
     */
    public static List<BusinessDomain> convert(List<DomainPO> domainPOList) {
        if (Objects.isNull(domainPOList) || domainPOList.size() <= 0) {
            return null;
        }
        List<BusinessDomain> businessDomainList = new ArrayList<>();
        for (DomainPO item : domainPOList) {
            businessDomainList.add(convert(item));
        }
        return businessDomainList;
    }

    public static BusinessDomainEntityPO convert(DomainEntity domainEntity) {
        if (Objects.isNull(domainEntity)) {
            return null;
        }
        BusinessDomainEntityPO domainEntityPO = new BusinessDomainEntityPO();
        domainEntityPO.setDomainCode(domainEntity.getDomainCode());
        domainEntityPO.setEntityIdCode(domainEntity.getEntityIdCode());
        domainEntityPO.setEntityIdAlias(domainEntity.getEntityIdAlias());
        domainEntityPO.setEntityIdName(domainEntity.getEntityIdName());
        domainEntityPO.setEntityIdType(domainEntity.getEntityIdType());
        domainEntityPO.setEntityDesc(domainEntity.getEntityDesc());
        return domainEntityPO;
    }

    public static DomainEntity convert(BusinessDomainEntityPO domainEntityPO) {
        if (Objects.isNull(domainEntityPO)) {
            return null;
        }
        DomainEntity domainEntity = new DomainEntity();
        domainEntity.setDomainCode(domainEntityPO.getDomainCode());
        domainEntity.setEntityIdCode(domainEntityPO.getEntityIdCode());
        domainEntity.setEntityIdAlias(domainEntityPO.getEntityIdAlias());
        domainEntity.setEntityIdName(domainEntityPO.getEntityIdName());
        domainEntity.setEntityIdType(domainEntityPO.getEntityIdType());
        domainEntity.setEntityDesc(domainEntityPO.getEntityDesc());
        return domainEntity;
    }

    public static BusinessDomainEntityAttrPO convert(DomainEntityAttr domainEntityAttr) {
        if (Objects.isNull(domainEntityAttr)) {
            return null;
        }
        BusinessDomainEntityAttrPO domainEntityAttrPO = new BusinessDomainEntityAttrPO();
        domainEntityAttrPO.setEntityIdCode(domainEntityAttr.getEntityIdCode());
        domainEntityAttrPO.setAttrName(domainEntityAttr.getAttrName());
        domainEntityAttrPO.setAttrType(domainEntityAttr.getAttrType());
        domainEntityAttrPO.setAttrDesc(domainEntityAttr.getAttrDesc());
        return domainEntityAttrPO;
    }

    public static BusinessDomainServicePO convert(DomainService domainService) {
        if (Objects.isNull(domainService)) {
            return null;
        }
        BusinessDomainServicePO domainServicePO = new BusinessDomainServicePO();
        domainServicePO.setDomainCode(domainService.getDomainCode());
        domainServicePO.setServiceCode(domainService.getServiceCode());
        domainServicePO.setServiceAlias(domainService.getServiceAlias());
        domainServicePO.setServiceName(domainService.getServiceName());
        domainServicePO.setServiceDesc(domainService.getServiceDesc());
        return domainServicePO;
    }

    public static BusinessDomainServiceAttrPO convert(DomainServiceAttr domainServiceAttr) {
        if (Objects.isNull(domainServiceAttr)) {
            return null;
        }
        BusinessDomainServiceAttrPO serviceAttrPO = new BusinessDomainServiceAttrPO();
        serviceAttrPO.setServiceCode(domainServiceAttr.getServiceCode());
        serviceAttrPO.setAttrName(domainServiceAttr.getAttrName());
        serviceAttrPO.setAttrType(domainServiceAttr.getAttrType());
        serviceAttrPO.setAttrDesc(domainServiceAttr.getAttrDesc());
        return serviceAttrPO;
    }

    public static BusinessDomainValueObjectPO convert(DomainValueObject domainValueObject) {
        if (Objects.isNull(domainValueObject)) {
            return null;
        }
        BusinessDomainValueObjectPO domainValueObjectPO = new BusinessDomainValueObjectPO();
        domainValueObjectPO.setDomainCode(domainValueObject.getDomainCode());
        domainValueObjectPO.setVoCode(domainValueObject.getVoCode());
        domainValueObjectPO.setVoAlias(domainValueObject.getVoAlias());
        domainValueObjectPO.setVoName(domainValueObject.getVoName());
        domainValueObjectPO.setVoDesc(domainValueObject.getVoDesc());
        return domainValueObjectPO;
    }

    public static BusinessDomainValueObjectAttrPO convert(DomainValueObjectAttr domainValueObjectAttr) {
        BusinessDomainValueObjectAttrPO valueObjectAttrPO = new BusinessDomainValueObjectAttrPO();
        valueObjectAttrPO.setVoCode(domainValueObjectAttr.getVoCode());
        valueObjectAttrPO.setAttrName(domainValueObjectAttr.getAttrName());
        valueObjectAttrPO.setAttrType(domainValueObjectAttr.getAttrType());
        valueObjectAttrPO.setAttrDesc(domainValueObjectAttr.getAttrDesc());
        return valueObjectAttrPO;
    }

    public static BusinessDomainEventPO convert(DomainEvent domainEvent) {
        BusinessDomainEventPO domainEventPO = new BusinessDomainEventPO();
        domainEventPO.setDomainCode(domainEvent.getDomainCode());
        domainEventPO.setEventCode(domainEvent.getEventCode());
        domainEventPO.setEventAlias(domainEvent.getEventAlias());
        domainEventPO.setEventName(domainEvent.getEventName());
        domainEventPO.setEventDesc(domainEvent.getEventDesc());
        return domainEventPO;
    }
}
