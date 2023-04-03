package com.bmf.core.utils;

import com.bmf.base.tactics.entity.EntityRelVO;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.valueobject.DomainValueObject;

/**
 * 领域工具类
 */
public class DomainUtil {

    public static EntityRelVO build(DomainEntity entity, DomainValueObject valueObject) {
        EntityRelVO entityRelVO = new EntityRelVO();
        entityRelVO.setEntityIdCode(entity.getEntityIdCode());
        entityRelVO.setVoCode(valueObject.getVoCode());
        return entityRelVO;
    }

}
