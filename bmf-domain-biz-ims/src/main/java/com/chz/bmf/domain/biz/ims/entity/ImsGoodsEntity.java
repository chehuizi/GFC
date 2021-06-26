package com.chz.bmf.domain.biz.ims.entity;

import lombok.Data;

@Data
public class ImsGoodsEntity extends BusinessEntity4Domain {

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
