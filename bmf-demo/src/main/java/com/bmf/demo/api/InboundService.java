package com.bmf.demo.api;

import com.bmf.base.annotations.BusinessApi;
import com.bmf.base.annotations.BusinessApplication;

/**
 * 入库服务
 */
@BusinessApplication(domainCode = 101, domainAlias = "wms")
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
