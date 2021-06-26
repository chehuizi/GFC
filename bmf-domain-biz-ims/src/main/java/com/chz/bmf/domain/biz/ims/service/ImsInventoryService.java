package com.chz.bmf.domain.biz.ims.service;

import com.chz.bmf.domain.base.tactics.flow.context.FlowInput;
import com.chz.bmf.domain.base.tactics.flow.context.FlowOutput;
import com.chz.bmf.domain.base.tactics.service.*;
import com.chz.bmf.domain.common.util.ServiceData2FlowDataUtil;

public class ImsInventoryService extends BusinessBaseService {

    @Override
    public <R extends ServiceReqDataBase, T extends ServiceRespDataBase> ServiceResp<T> invoke(ServiceReq<R> serviceReq) {
        FlowInput flowInput = ServiceData2FlowDataUtil.convertServiceData2FlowData(serviceReq);
        FlowOutput flowOutput = this.getFlowEngine().trigger(flowInput);
        ServiceResp serviceResp = ServiceData2FlowDataUtil.convertFlowData2ServiceData(flowOutput);
        return serviceResp;
    }
}
