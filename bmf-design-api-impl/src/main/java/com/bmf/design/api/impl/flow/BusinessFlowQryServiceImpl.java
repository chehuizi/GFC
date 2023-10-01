package com.bmf.design.api.impl.flow;

import com.bmf.design.api.Result;
import com.bmf.design.api.flow.BusinessFlowQryService;
import com.bmf.design.api.flow.dto.BusinessFlowQryReqDTO;
import com.bmf.design.api.flow.dto.BusinessFlowRespDTO;
import com.bmf.design.base.flow.BusinessFlow;
import com.bmf.design.base.flow.BusinessFlowNode;
import com.bmf.design.common.utils.ResultUtil;
import com.bmf.design.core.design.BusinessFlowDesign;
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
