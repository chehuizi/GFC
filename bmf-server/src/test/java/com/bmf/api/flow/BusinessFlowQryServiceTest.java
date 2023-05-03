package com.bmf.api.flow;

import com.bmf.api.Result;
import com.bmf.api.flow.dto.BusinessFlowCmdReqDTO;
import com.bmf.api.flow.dto.BusinessFlowQryReqDTO;
import com.bmf.api.flow.dto.BusinessFlowRespDTO;
import com.bmf.base.Business;
import com.bmf.base.enums.BusinessFlowNodeTypeEnum;
import com.bmf.base.enums.DomainElementEnum;
import com.bmf.base.flow.BusinessFlow;
import com.bmf.base.flow.BusinessFlowNode;
import com.bmf.common.enums.ResultCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessFlowQryServiceTest {

    @Autowired
    private BusinessFlowQryService businessFlowQryService;

    @Test
    public void test_business_flow_query_one() {
        BusinessFlowQryReqDTO qryReqDTO = new BusinessFlowQryReqDTO();
        BusinessFlow businessFlow = new BusinessFlow();
        businessFlow.setBusinessCode(102);
        businessFlow.setFlowId(1001);
        qryReqDTO.setBusinessFlow(businessFlow);
        Result<BusinessFlowRespDTO> result = businessFlowQryService.queryOne(qryReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

}
