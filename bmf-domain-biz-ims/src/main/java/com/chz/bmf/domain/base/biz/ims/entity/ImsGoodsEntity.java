package com.chz.bmf.domain.base.biz.ims.entity;

import com.chz.bmf.domain.base.entity.BusinessEntity4Domain;
import lombok.Data;

@Data
public class ImsGoodsEntity extends BusinessEntity4Domain {

    private String sku;
    private String spu;
}
