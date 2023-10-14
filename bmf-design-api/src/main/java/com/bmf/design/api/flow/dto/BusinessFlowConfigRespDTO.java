package com.bmf.design.api.flow.dto;

import com.bmf.design.api.RespDTO;
import com.bmf.design.base.flow.BusinessFlow;
import com.bmf.design.base.flow.BusinessFlowNode;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BusinessFlowConfigRespDTO extends RespDTO implements Serializable {

    /**
     * 业务流程
     */
    private BusinessFlow businessFlow;
    /**
     * 流程节点列表
     */
    private List<BusinessFlowNode> flowNodeList;
}
