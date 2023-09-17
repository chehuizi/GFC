package com.bmf.demo.api;

import com.bmf.base.annotations.DomainApi;
import com.bmf.base.annotations.DomainApiClass;

/**
 * 出库服务
 */
@DomainApiClass
public interface OutboundService {

    /**
     * 创建出库单
     * @return
     */
    @DomainApi(serviceCode = 10001, serviceAlias = "outbound_create_order_service")
    String createOutboundOrder();

    /**
     * 取消出库单
     * @return
     */
    boolean cancelOutboundOrder();
}
