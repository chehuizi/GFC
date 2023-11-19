package com.bmf.design.model.view;

import com.bmf.common.model.BaseModel;
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
