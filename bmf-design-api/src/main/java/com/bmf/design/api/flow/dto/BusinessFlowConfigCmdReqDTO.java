package com.bmf.design.api.flow.dto;

import com.bmf.common.api.ReqDTO;
import com.bmf.design.model.Business;
import com.bmf.design.model.flow.BusinessFlow;
import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessFlowConfigCmdReqDTO extends ReqDTO implements Serializable {

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
