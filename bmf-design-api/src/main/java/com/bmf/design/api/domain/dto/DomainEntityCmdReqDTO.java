package com.bmf.design.api.domain.dto;

import com.bmf.common.api.ReqDTO;
import com.bmf.design.model.tactics.entity.DomainEntity;
import com.bmf.design.model.tactics.entity.DomainEntityAttr;
import lombok.Data;

import java.io.Serializable;

/**
 * 领域实体请求对象
 */
@Data
public class DomainEntityCmdReqDTO extends ReqDTO implements Serializable {

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
