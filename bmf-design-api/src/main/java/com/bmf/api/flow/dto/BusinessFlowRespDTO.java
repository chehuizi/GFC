package com.bmf.api.flow.dto;

import com.bmf.api.RespDTO;
import com.bmf.base.flow.BusinessFlow;
import com.bmf.base.flow.BusinessFlowNode;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BusinessFlowRespDTO extends RespDTO implements Serializable {

    /**
     * 业务流程
     */
    private BusinessFlow businessFlow;
    /**
     * 流程节点列表
     */
    private List<BusinessFlowNode> flowNodeList;
}
