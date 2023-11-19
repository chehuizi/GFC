package com.bmf.design.api.domain.dto;

import com.bmf.common.api.RespDTO;
import com.bmf.design.model.tactics.service.DomainService;
import com.bmf.design.model.tactics.service.DomainServiceAttr;
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
