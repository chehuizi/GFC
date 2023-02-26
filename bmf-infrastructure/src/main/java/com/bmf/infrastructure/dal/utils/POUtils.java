package com.bmf.infrastructure.dal.utils;

import com.bmf.base.BaseModel;
import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.valueobject.DomainValueObject;
import com.bmf.infrastructure.dal.po.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PO工具类
 */
public class POUtils {

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

    public static DomainValueObject convert(BusinessDomainValueObjectPO domainValueObjectPO) {
        if (Objects.isNull(domainValueObjectPO)) {
            return null;
        }
        DomainValueObject domainValueObject = new DomainValueObject();
        domainValueObject.setDomainCode(domainValueObjectPO.getDomainCode());
        domainValueObject.setVoCode(domainValueObjectPO.getVoCode());
        domainValueObject.setVoAlias(domainValueObjectPO.getVoAlias());
        domainValueObject.setVoName(domainValueObjectPO.getVoName());
        domainValueObject.setVoDesc(domainValueObjectPO.getVoDesc());
        return domainValueObject;
    }

    /**
     * 模型对象转持久化对象
     * @param src
     * @param dstClass
     * @param <R>
     * @param <T>
     * @return
     */
    public static  <R extends BaseModel, T extends BasePO> T convert(R src, Class<T> dstClass) {
        if (Objects.isNull(src)) {
            return null;
        }
        try {
            T dst = dstClass.newInstance();
            BeanUtils.copyProperties(src, dst);
            return dst;
        } catch (Exception ex) {

        }
        return null;
    }
}
