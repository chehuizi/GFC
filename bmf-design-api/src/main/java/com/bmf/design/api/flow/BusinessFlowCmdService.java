package com.bmf.design.api.flow;

import com.bmf.design.api.CmdService;
import com.bmf.design.api.Result;
import com.bmf.design.api.flow.dto.BusinessFlowCmdReqDTO;

public interface BusinessFlowCmdService extends CmdService<BusinessFlowCmdReqDTO> {

    /**
     * 添加流程节点
     * @param businessFlowCmdReqDTO
     * @return
     */
    Result<Boolean> addFlowNode(BusinessFlowCmdReqDTO businessFlowCmdReqDTO);
}
