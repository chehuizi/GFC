package com.bmf.demo.api;

import com.bmf.base.annotations.DomainApi;
import com.bmf.base.annotations.DomainApiClass;

/**
 * 盘点服务
 */
@DomainApiClass
public interface InventoryService {

    /**
     * 创建盘点单
     * @return
     */
    @DomainApi(serviceCode = 10003, serviceAlias = "inventory_create_order_service")
    String createInventoryOrder();

    /**
     * 取消盘点单
     * @return
     */
    boolean cancelInventoryOrder();
}
