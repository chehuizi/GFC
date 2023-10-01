package com.bmf.core.utils;

import com.bmf.base.tactics.entity.DomainEntityRelVO;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.valueobject.DomainValueObject;

/**
 * 领域工具类
 */
public class DomainUtil {

    public static DomainEntityRelVO build(DomainEntity entity, DomainValueObject valueObject) {
        DomainEntityRelVO domainEntityRelVO = new DomainEntityRelVO();
        domainEntityRelVO.setEntityIdCode(entity.getEntityIdCode());
        domainEntityRelVO.setVoCode(valueObject.getVoCode());
        return domainEntityRelVO;
    }

}
