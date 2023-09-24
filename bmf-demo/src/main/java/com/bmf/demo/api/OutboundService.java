package com.bmf.demo.api;

import com.bmf.annotations.DomainService;
import com.bmf.annotations.DomainServiceClass;

/**
 * 出库服务
 */
@DomainServiceClass
public interface OutboundService {

    /**
     * 创建出库单
     * @return
     */
    @DomainService(serviceCode = 10001, serviceAlias = "outbound_create_order_service")
    String createOutboundOrder();

    /**
     * 取消出库单
     * @return
     */
    boolean cancelOutboundOrder();
}
