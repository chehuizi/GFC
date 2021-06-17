package com.chz.bmf.domain.common.util;

import com.chz.bmf.domain.base.flow.context.FlowInput;
import com.chz.bmf.domain.base.flow.context.FlowInputDataBase;
import com.chz.bmf.domain.base.flow.context.FlowOutput;
import com.chz.bmf.domain.base.flow.context.FlowOutputDataBase;
import com.chz.bmf.domain.base.service.ServiceReq;
import com.chz.bmf.domain.base.service.ServiceReqDataBase;
import com.chz.bmf.domain.base.service.ServiceResp;
import com.chz.bmf.domain.base.service.ServiceRespDataBase;

public class ServiceData2FlowDataUtil {

    public static <T extends FlowInputDataBase, R extends ServiceReqDataBase> FlowInput<T> convertServiceData2FlowData(ServiceReq<R> serviceReq) {
        return null;
    }

    public static <T extends ServiceRespDataBase, R extends FlowOutputDataBase> ServiceResp<T> convertFlowData2ServiceData(FlowOutput<R> flowOutput) {
        return null;
    }
}
