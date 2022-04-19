package com.bmf.domain.common.util;

import com.bmf.domain.base.tactics.flow.context.FlowInput;
import com.bmf.domain.base.tactics.flow.context.FlowInputDataBase;
import com.bmf.domain.base.tactics.flow.context.FlowOutput;
import com.bmf.domain.base.tactics.flow.context.FlowOutputDataBase;
import com.bmf.domain.base.tactics.service.ServiceReq;
import com.bmf.domain.base.tactics.service.ServiceReqDataBase;
import com.bmf.domain.base.tactics.service.ServiceResp;
import com.bmf.domain.base.tactics.service.ServiceRespDataBase;

public class ServiceData2FlowDataUtil {

    public static <T extends FlowInputDataBase, R extends ServiceReqDataBase> FlowInput<T> convertServiceData2FlowData(ServiceReq<R> serviceReq) {
        return null;
    }

    public static <T extends ServiceRespDataBase, R extends FlowOutputDataBase> ServiceResp<T> convertFlowData2ServiceData(FlowOutput<R> flowOutput) {
        return null;
    }
}
