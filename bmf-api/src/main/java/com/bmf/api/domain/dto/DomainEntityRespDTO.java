package com.bmf.api.domain.dto;

import com.bmf.api.RespDTO;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.entity.DomainEntityAttr;
import com.bmf.base.tactics.valueobject.DomainValueObject;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 领域实体返回对象
 */
@Data
@NoArgsConstructor
public class DomainEntityRespDTO extends RespDTO implements Serializable {

    /**
     * 领域实体
     */
    private DomainEntity domainEntity;
    /**
     * 实体属性列表
     */
    private List<DomainEntityAttr> entityAttrList;
    /**
     * 实体值对象列表
     */
    private List<DomainValueObject> voList;
}
