package com.bmf.common.api;

import lombok.Data;

import java.io.Serializable;

@Data
public class RespDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 6326557382290893971L;

    /**
     * 总数量
     */
    private int total;
    /**
     * 页大小
     */
    private int pageSize;
    /**
     * 页码
     */
    private int pageIndex;

}
