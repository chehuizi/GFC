package com.bmf.dev.demo.rpc;


import com.bmf.dev.annotations.DomainService;
import com.bmf.dev.annotations.DomainServiceClass;

/**
 * 入库服务
 */
@DomainServiceClass
public interface InboundService {

    /**
     * 创建入库单
     * @return
     */
    @DomainService(serviceCode = 100020, serviceAlias = "inbound_create_order_service")
    String createInboundOrder();

    /**
     * 取消入库单
     * @return
     */
    @DomainService(serviceCode = 100021, serviceAlias = "inbound_cancel_order_service")
    boolean cancelInboundOrder();
}
