package com.bmf.domain.api;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReqDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -5969969445009315401L;

    /**
     * 页大小
     */
    private int pageSize;

    /**
     * 页码
     */
    private int pageIndex;
}
