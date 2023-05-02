package com.bmf.api.flow;

import com.bmf.api.CmdService;
import com.bmf.api.Result;
import com.bmf.api.flow.dto.BusinessFlowCmdReqDTO;

public interface BusinessFlowCmdService extends CmdService<BusinessFlowCmdReqDTO> {

    /**
     * 添加流程节点
     * @param businessFlowCmdReqDTO
     * @return
     */
    Result<Boolean> addFlowNode(BusinessFlowCmdReqDTO businessFlowCmdReqDTO);
}
