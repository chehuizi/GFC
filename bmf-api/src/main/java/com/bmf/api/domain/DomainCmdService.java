package com.bmf.api.domain;

import com.bmf.api.CmdService;
import com.bmf.api.Result;

/**
 * 业务域cmd服务
 */
public interface DomainCmdService extends CmdService<DomainReqDTO> {

    /**
     * 添加业务实体
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> addEntity(DomainReqDTO domainReqDTO);

    /**
     * 添加值对象
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> addValueObject(DomainReqDTO domainReqDTO);

    /**
     * 添加实体和值对象关系
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> addEntityRelVO(DomainReqDTO domainReqDTO);

    /**
     * 添加聚合根
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> addAggregate(DomainReqDTO domainReqDTO);

    /**
     * 添加领域服务
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> addService(DomainReqDTO domainReqDTO);

    /**
     * 添加领域事件
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> addDomainEvent(DomainReqDTO domainReqDTO);
}
