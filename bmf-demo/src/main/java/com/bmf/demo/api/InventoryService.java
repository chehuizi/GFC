package com.bmf.demo.api;

import com.bmf.annotations.DomainService;
import com.bmf.annotations.DomainServiceClass;

/**
 * 盘点服务
 */
@DomainServiceClass
public interface InventoryService {

    /**
     * 创建盘点单
     * @return
     */
    @DomainService(serviceCode = 10003, serviceAlias = "inventory_create_order_service")
    String createInventoryOrder();

    /**
     * 取消盘点单
     * @return
     */
    boolean cancelInventoryOrder();
}
