package com.bmf.design.api.flow;

import com.bmf.design.api.CmdService;
import com.bmf.design.api.Result;
import com.bmf.design.api.flow.dto.BusinessFlowConfigCmdReqDTO;

public interface BusinessFlowConfigCmdService extends CmdService<BusinessFlowConfigCmdReqDTO> {

    /**
     * 添加流程节点
     * @param businessFlowConfigCmdReqDTO
     * @return
     */
    Result<Boolean> addFlowNode(BusinessFlowConfigCmdReqDTO businessFlowConfigCmdReqDTO);
}
