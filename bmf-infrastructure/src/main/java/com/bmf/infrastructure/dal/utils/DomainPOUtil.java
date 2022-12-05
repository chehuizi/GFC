package com.bmf.infrastructure.dal.utils;

import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.DomainRelEntity;
import com.bmf.base.tactics.entity.BusinessDomainEntity;
import com.bmf.base.tactics.entity.DomainEntityAttr;
import com.bmf.base.tactics.valueobject.BusinessDomainValueObject;
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

    public static BusinessDomainEntityPO convert(BusinessDomainEntity businessDomainEntity) {
        BusinessDomainEntityPO domainEntityPO = new BusinessDomainEntityPO();
        domainEntityPO.setEntityIdCode(businessDomainEntity.getEntityIdCode());
        domainEntityPO.setEntityIdName(businessDomainEntity.getEntityIdName());
        domainEntityPO.setEntityIdType(businessDomainEntity.getEntityIdType());
        return domainEntityPO;
    }

    public static BusinessDomainEntityAttrPO convert(DomainEntityAttr domainEntityAttr) {
        BusinessDomainEntityAttrPO domainEntityAttrPO = new BusinessDomainEntityAttrPO();
        domainEntityAttrPO.setEntityIdCode(domainEntityAttr.getEntityIdCode());
        domainEntityAttrPO.setAttrName(domainEntityAttr.getAttrName());
        domainEntityAttrPO.setAttrType(domainEntityAttr.getAttrType());
        domainEntityAttrPO.setAttrDesc(domainEntityAttr.getAttrDesc());
        return domainEntityAttrPO;
    }

    public static BusinessDomainRelEntityPO convert(DomainRelEntity domainRelEntity) {
        BusinessDomainRelEntityPO domainRelEntityPO = new BusinessDomainRelEntityPO();
        domainRelEntityPO.setDomainCode(domainRelEntity.getDomainCode());
        domainRelEntityPO.setEntityIdCode(domainRelEntity.getEntityIdCode());
        return domainRelEntityPO;
    }

    public static BusinessDomainValueObjectPO convert(BusinessDomainValueObject businessDomainValueObject) {
        return null;
    }
}
