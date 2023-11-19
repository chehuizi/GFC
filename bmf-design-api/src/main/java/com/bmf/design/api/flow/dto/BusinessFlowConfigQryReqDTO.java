package com.bmf.design.api.flow.dto;

import com.bmf.common.api.ReqDTO;
import com.bmf.design.model.flow.BusinessFlow;
import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessFlowConfigQryReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = 976430197336158324L;

    /**
     * 业务流程
     */
    private BusinessFlow businessFlow;
}
