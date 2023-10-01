package com.bmf.design.api.business.dto;

import com.bmf.design.api.RespDTO;
import com.bmf.design.base.Business;
import lombok.Data;

import java.io.Serializable;

/**
 * 业务返回对象
 */
@Data
public class BusinessRespDTO extends RespDTO implements Serializable {

    private static final long serialVersionUID = 599551726802332940L;

    private Business business;

    public BusinessRespDTO(Business business) {
        this.business = business;
    }
}
