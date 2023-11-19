package com.bmf.design.api.impl.flow;

import com.bmf.common.api.Result;
import com.bmf.design.api.flow.BusinessFlowConfigQryService;
import com.bmf.design.api.flow.dto.BusinessFlowConfigQryReqDTO;
import com.bmf.design.api.flow.dto.BusinessFlowConfigRespDTO;
import com.bmf.design.model.flow.BusinessFlow;
import com.bmf.common.api.utils.ResultUtil;
import com.bmf.design.core.flow.BusinessFlowDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessFlowConfigQryServiceImpl implements BusinessFlowConfigQryService {

    @Autowired
    private BusinessFlowDesign businessFlowDesign;

    @Override
    public Result<BusinessFlowConfigRespDTO> queryOne(BusinessFlowConfigQryReqDTO req) {
        BusinessFlow businessFlow = businessFlowDesign.queryFlow(req.getBusinessFlow());
        BusinessFlowConfigRespDTO respDTO = new BusinessFlowConfigRespDTO();
        respDTO.setBusinessFlow(businessFlow);
        return ResultUtil.success(respDTO);
    }
}
