package com.bmf.infrastructure.dal.utils;

import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.entity.DomainEntityAttr;
import com.bmf.base.tactics.valueobject.DomainValueObject;
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
        BusinessDomainEntityAttrPO domainEntityAttrPO = new BusinessDomainEntityAttrPO();
        domainEntityAttrPO.setEntityIdCode(domainEntityAttr.getEntityIdCode());
        domainEntityAttrPO.setAttrName(domainEntityAttr.getAttrName());
        domainEntityAttrPO.setAttrType(domainEntityAttr.getAttrType());
        domainEntityAttrPO.setAttrDesc(domainEntityAttr.getAttrDesc());
        return domainEntityAttrPO;
    }

    public static BusinessDomainValueObjectPO convert(DomainValueObject domainValueObject) {
        return null;
    }
}
