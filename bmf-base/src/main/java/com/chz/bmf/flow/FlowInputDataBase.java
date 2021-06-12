package com.chz.bmf.flow;

import lombok.Data;

import java.io.Serializable;

@Data
public class FlowInputDataBase implements Serializable {

    private static final long serialVersionUID = -7118088687647791720L;

    private String service
    /**
     * 流程类型
     */
    private String flowType;
    /**
     * 业务唯一标识
     */
    private String bizId;
}
