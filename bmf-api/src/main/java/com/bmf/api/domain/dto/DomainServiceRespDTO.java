package com.bmf.api.domain.dto;

import com.bmf.api.RespDTO;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.entity.DomainEntityAttr;
import com.bmf.base.tactics.service.DomainService;
import com.bmf.base.tactics.service.DomainServiceAttr;
import com.bmf.base.tactics.valueobject.DomainValueObject;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 领域服务返回对象
 */
@Data
@NoArgsConstructor
public class DomainServiceRespDTO extends RespDTO implements Serializable {

    private static final long serialVersionUID = -4071361431532761462L;

    /**
     * 领域服务
     */
    private DomainService domainService;
    /**
     * 服务属性列表
     */
    private List<DomainServiceAttr> serviceAttrList;
}
