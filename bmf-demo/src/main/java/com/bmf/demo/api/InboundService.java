package com.bmf.demo.api;

import com.bmf.base.annotations.DomainApi;
import com.bmf.base.annotations.DomainApiClass;

/**
 * 入库服务
 */
@DomainApiClass
public interface InboundService {

    /**
     * 创建入库单
     * @return
     */
    @DomainApi(serviceCode = 10002, serviceAlias = "inbound_create_order_service")
    String createInboundOrder();

    /**
     * 取消入库单
     * @return
     */
    boolean cancelInboundOrder();
}
