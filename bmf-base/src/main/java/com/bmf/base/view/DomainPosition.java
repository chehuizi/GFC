package com.bmf.base.view;

import com.bmf.base.BaseModel;
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
