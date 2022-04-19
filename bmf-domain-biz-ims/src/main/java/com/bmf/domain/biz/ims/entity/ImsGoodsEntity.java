package com.bmf.domain.biz.ims.entity;

import com.bmf.domain.base.tactics.entity.BusinessEntity;
import lombok.Data;

@Data
public class ImsGoodsEntity extends BusinessEntity {

    /**
     * 货品SKU
     */
    private String sku;
    /**
     * 货品SPU
     */
    private String spu;

    @Override
    public String buildBusinessEntityId() {
        return this.getSpu() + "_" + this.getSku();
    }
}
