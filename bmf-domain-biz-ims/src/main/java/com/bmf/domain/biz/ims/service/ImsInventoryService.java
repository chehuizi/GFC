package com.bmf.domain.biz.ims.service;

import com.bmf.domain.base.tactics.flow.context.FlowInput;
import com.bmf.domain.base.tactics.flow.context.FlowOutput;
import com.bmf.domain.common.util.ServiceData2FlowDataUtil;
import com.bmf.domain.base.tactics.service.*;

public class ImsInventoryService extends BusinessBaseService {

    @Override
    public <R extends ServiceReqDataBase, T extends ServiceRespDataBase> ServiceResp<T> invoke(ServiceReq<R> serviceReq) {
        FlowInput flowInput = ServiceData2FlowDataUtil.convertServiceData2FlowData(serviceReq);
        FlowOutput flowOutput = this.getFlowEngine().trigger(flowInput);
        ServiceResp serviceResp = ServiceData2FlowDataUtil.convertFlowData2ServiceData(flowOutput);
        return serviceResp;
    }
}
