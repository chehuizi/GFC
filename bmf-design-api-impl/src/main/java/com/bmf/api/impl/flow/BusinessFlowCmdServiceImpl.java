package com.bmf.api.impl.flow;

import com.bmf.api.Result;
import com.bmf.api.flow.BusinessFlowCmdService;
import com.bmf.api.flow.dto.BusinessFlowCmdReqDTO;
import com.bmf.base.Business;
import com.bmf.base.enums.CodeKeyEnum;
import com.bmf.base.flow.BusinessFlow;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.business.BusinessService;
import com.bmf.core.design.BusinessFlowDesign;
import com.bmf.infrastructure.generator.CodeSeqGenerator;
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
