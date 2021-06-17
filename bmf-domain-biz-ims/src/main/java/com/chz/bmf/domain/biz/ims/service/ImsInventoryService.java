package com.chz.bmf.domain.biz.ims.service;

import com.chz.bmf.domain.base.flow.context.FlowInput;
import com.chz.bmf.domain.base.flow.context.FlowOutput;
import com.chz.bmf.domain.base.service.*;
import com.chz.bmf.domain.common.util.ServiceData2FlowDataUtil;

public class ImsInventoryService extends BusinessServiceBase4Domain {

    @Override
    public <R extends ServiceReqDataBase, T extends ServiceRespDataBase> ServiceResp<T> invoke(ServiceReq<R> serviceReq) {
        FlowInput flowInput = ServiceData2FlowDataUtil.convertServiceData2FlowData(serviceReq);
        FlowOutput flowOutput = this.getFlowEngine().trigger(flowInput);
        ServiceResp serviceResp = ServiceData2FlowDataUtil.convertFlowData2ServiceData(flowOutput);
        return serviceResp;
    }
}
