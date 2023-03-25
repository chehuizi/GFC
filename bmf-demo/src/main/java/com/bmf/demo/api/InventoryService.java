package com.bmf.demo.api;

import com.bmf.base.annotations.BusinessApi;

/**
 * 盘点服务
 */
public interface InventoryService {

    /**
     * 创建盘点单
     * @return
     */
    @BusinessApi(serviceCode = 10003, serviceAlias = "inventory_create_order_service")
    String createOutboundOrder();

    /**
     * 取消盘点单
     * @return
     */
    boolean cancelOutboundOrder();
}
