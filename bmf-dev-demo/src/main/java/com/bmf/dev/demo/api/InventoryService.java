package com.bmf.dev.demo.api;

import com.bmf.dev.annotations.DomainService;
import com.bmf.dev.annotations.DomainServiceClass;

/**
 * 盘点服务
 */
@DomainServiceClass
public interface InventoryService {

    /**
     * 创建盘点单
     * @return
     */
    @DomainService(serviceCode = 100030, serviceAlias = "inventory_create_order_service")
    String createInventoryOrder();

    /**
     * 取消盘点单
     * @return
     */
    @DomainService(serviceCode = 100031, serviceAlias = "inventory_cancel_order_service")
    boolean cancelInventoryOrder();
}
