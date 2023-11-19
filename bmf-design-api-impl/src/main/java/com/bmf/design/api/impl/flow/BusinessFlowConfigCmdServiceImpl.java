package com.bmf.design.api.impl.flow;

import com.bmf.common.api.Result;
import com.bmf.design.api.flow.BusinessFlowConfigCmdService;
import com.bmf.design.api.flow.dto.BusinessFlowConfigCmdReqDTO;
import com.bmf.design.model.Business;
import com.bmf.design.model.enums.CodeKeyEnum;
import com.bmf.design.model.flow.BusinessFlow;
import com.bmf.design.model.flow.BusinessFlowNode;
import com.bmf.common.api.enums.BizCodeEnum;
import com.bmf.common.utils.checker.BusinessCheckUtil;
import com.bmf.common.api.utils.ResultUtil;
import com.bmf.common.api.validator.Validator;
import com.bmf.design.core.business.BusinessService;
import com.bmf.design.core.flow.BusinessFlowDesign;
import com.bmf.design.infrastructure.generator.CodeSeqGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BusinessFlowConfigCmdServiceImpl implements BusinessFlowConfigCmdService {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private BusinessFlowDesign businessFlowDesign;
    @Autowired
    private CodeSeqGenerator codeSeqGenerator;

    @Override
    @Validator(beanName = "businessFlowCmdReqDTOValidator", method = "v4Create")
    public Result<Boolean> create(BusinessFlowConfigCmdReqDTO req) {
        Business business = businessService.queryBusiness(req.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        BusinessFlow businessFlow = businessFlowDesign.queryFlow(req.getBusinessFlow());
        if (Objects.nonNull(businessFlow)) {
            return ResultUtil.success(businessFlowDesign.updateFlow(businessFlow));
        }
        Integer flowId = codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_FLOW.getKey());
        req.getBusinessFlow().setFlowId(flowId);
        for (BusinessFlowNode node : req.getBusinessFlow().getNodeList()) {
            node.setFlowId(flowId);
        }
        return ResultUtil.success(businessFlowDesign.addFlow(req.getBusinessFlow()));
    }

    @Override
    public Result<Boolean> update(BusinessFlowConfigCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(BusinessFlowConfigCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }
}
