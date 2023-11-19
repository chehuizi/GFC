package com.bmf.design.api.domain.dto;

import com.bmf.common.api.ReqDTO;
import com.bmf.design.model.Business;
import com.bmf.design.model.Domain;
import lombok.Data;

import java.io.Serializable;

/**
 * 领域请求参数对象
 */
@Data
public class DomainQryReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = 1781863846052662235L;

    /**
     * 业务
     */
    private Business business;
    /**
     * 业务领域
     */
    private Domain domain;
    /**
     * 包括领域实体
     */
    private boolean includeEntity;
    /**
     * 包括领域服务
     */
    private boolean includeService;
    /**
     * 包括领域事件
     */
    private boolean includeEvent;
}
