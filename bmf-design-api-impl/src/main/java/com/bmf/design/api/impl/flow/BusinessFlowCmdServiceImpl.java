package com.bmf.design.api.impl.flow;

import com.bmf.design.api.Result;
import com.bmf.design.api.flow.BusinessFlowCmdService;
import com.bmf.design.api.flow.dto.BusinessFlowCmdReqDTO;
import com.bmf.design.base.Business;
import com.bmf.design.base.enums.CodeKeyEnum;
import com.bmf.design.base.flow.BusinessFlow;
import com.bmf.design.common.enums.BizCodeEnum;
import com.bmf.design.common.utils.BusinessCheckUtil;
import com.bmf.design.common.utils.ResultUtil;
import com.bmf.design.common.validator.Validator;
import com.bmf.design.core.business.BusinessService;
import com.bmf.design.core.design.BusinessFlowDesign;
import com.bmf.design.infrastructure.generator.CodeSeqGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessFlowCmdServiceImpl implements BusinessFlowCmdService {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private BusinessFlowDesign businessFlowDesign;
    @Autowired
    private CodeSeqGenerator codeSeqGenerator;

    @Override
    @Validator(beanName = "businessFlowCmdReqDTOValidator", method = "v4Create")
    public Result<Boolean> create(BusinessFlowCmdReqDTO req) {
        Business business = businessService.queryBusiness(req.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        req.getBusinessFlow().setFlowId(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_FLOW.getKey()));
        req.initStartNode();
        req.getBusinessFlowNode().setNodeId(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_NODE.getKey()));
        return ResultUtil.success(businessFlowDesign.addFlow(req.getBusinessFlow(),
                req.getBusinessFlowNode()));
    }

    @Override
    public Result<Boolean> update(BusinessFlowCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(BusinessFlowCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    @Validator(beanName = "businessFlowCmdReqDTOValidator", method = "v4AddFlowNode")
    public Result<Boolean> addFlowNode(BusinessFlowCmdReqDTO businessFlowCmdReqDTO) {
        BusinessFlow businessFlow = businessFlowDesign.queryFlow(businessFlowCmdReqDTO.getBusinessFlow());
        BusinessCheckUtil.checkNull(businessFlow, BizCodeEnum.BUSINESS_FLOW_NOT_EXIST);
        businessFlowCmdReqDTO.getBusinessFlowNode().setNodeId(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_NODE.getKey()));
        return ResultUtil.success(businessFlowDesign.addFlowNode(businessFlowCmdReqDTO.getBusinessFlowNode()));
    }
}
