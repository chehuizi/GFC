package com.bmf.api.impl.flow;

import com.bmf.api.Result;
import com.bmf.api.flow.BusinessFlowQryService;
import com.bmf.api.flow.dto.BusinessFlowQryReqDTO;
import com.bmf.api.flow.dto.BusinessFlowRespDTO;
import com.bmf.base.flow.BusinessFlow;
import com.bmf.base.flow.BusinessFlowNode;
import com.bmf.common.utils.ResultUtil;
import com.bmf.core.design.BusinessFlowDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessFlowQryServiceImpl implements BusinessFlowQryService {

    @Autowired
    private BusinessFlowDesign businessFlowDesign;

    @Override
    public Result<BusinessFlowRespDTO> queryOne(BusinessFlowQryReqDTO req) {
        BusinessFlow businessFlow = businessFlowDesign.queryFlow(req.getBusinessFlow());
        List<BusinessFlowNode> flowNodeList = businessFlowDesign.queryFlowNode(req.getBusinessFlow());
        BusinessFlowRespDTO respDTO = new BusinessFlowRespDTO();
        respDTO.setBusinessFlow(businessFlow);
        respDTO.setFlowNodeList(flowNodeList);
        return ResultUtil.success(respDTO);
    }
}
