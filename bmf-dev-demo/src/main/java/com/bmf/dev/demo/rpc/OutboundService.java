package com.bmf.dev.demo.rpc;

import com.bmf.dev.annotations.DomainService;
import com.bmf.dev.annotations.DomainServiceClass;

/**
 * 出库服务
 */
@DomainServiceClass
public interface OutboundService {

    /**
     * 创建出库单
     * @return
     */
    @DomainService(serviceCode = 100010, serviceAlias = "outbound_create_order_service")
    String createOutboundOrder();

    /**
     * 取消出库单
     * @return
     */
    @DomainService(serviceCode = 100011, serviceAlias = "outbound_cancel_order_service")
    boolean cancelOutboundOrder();
}
