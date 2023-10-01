package com.bmf.design.base.view;

import com.bmf.design.base.BaseModel;
import lombok.Data;

@Data
public class DomainPosition extends BaseModel {

    /**
     * X轴
     */
    private Integer x;
    /**
     * Y轴
     */
    private Integer y;
}
