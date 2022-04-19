package com.bmf.domain.base.tactics.service;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceReqDataBase implements Serializable {

    private static final long serialVersionUID = -7118088687647791720L;

    /**
     * 业务类型
     */
    private String bizType;
    /**
     * 业务唯一标识
     */
    private String bizId;
}
