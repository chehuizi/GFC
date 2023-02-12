package com.bmf.api.domain.dto;

import com.bmf.api.ReqDTO;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.entity.DomainEntityAttr;
import lombok.Data;

import java.io.Serializable;

/**
 * 领域实体请求对象
 */
@Data
public class DomainEntityReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = 7117437636269923763L;

    /**
     * 领域实体
     */
    private DomainEntity domainEntity;
    /**
     * 实体属性
     */
    private DomainEntityAttr entityAttr;
}
