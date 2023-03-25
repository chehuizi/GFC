package com.bmf.demo.api;

import com.bmf.base.annotations.BusinessApi;

/**
 * 入库服务
 */
public interface InboundService {

    /**
     * 创建入库单
     * @return
     */
    @BusinessApi(serviceCode = 10002, serviceAlias = "inbound_create_order_service")
    String createOutboundOrder();

    /**
     * 取消入库单
     * @return
     */
    boolean cancelOutboundOrder();
}
