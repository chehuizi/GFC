package com.bmf.demo.api;

import com.bmf.base.annotations.DomainService;
import com.bmf.base.annotations.DomainServiceClass;

/**
 * 入库服务
 */
@DomainServiceClass
public interface InboundService {

    /**
     * 创建入库单
     * @return
     */
    @DomainService(serviceCode = 10002, serviceAlias = "inbound_create_order_service")
    String createInboundOrder();

    /**
     * 取消入库单
     * @return
     */
    boolean cancelInboundOrder();
}
