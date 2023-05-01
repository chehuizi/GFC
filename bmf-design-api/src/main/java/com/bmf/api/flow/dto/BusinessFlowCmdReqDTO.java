package com.bmf.api.flow.dto;

import com.bmf.api.ReqDTO;
import com.bmf.base.Business;
import com.bmf.base.flow.BusinessFlow;
import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessFlowCmdReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = -2692178052647653883L;

    /**
     * 业务
     */
    private Business business;
    /**
     * 业务流程
     */
    private BusinessFlow businessFlow;
}
