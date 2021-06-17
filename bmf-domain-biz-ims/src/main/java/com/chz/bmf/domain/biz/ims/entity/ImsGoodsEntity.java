package com.chz.bmf.domain.biz.ims.entity;

import com.chz.bmf.domain.entity.BusinessEntity4Domain;
import lombok.Data;

@Data
public class ImsGoodsEntity extends BusinessEntity4Domain {

    private String sku;
    private String spu;
}
