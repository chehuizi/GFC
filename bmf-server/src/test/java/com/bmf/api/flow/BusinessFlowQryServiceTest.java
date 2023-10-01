package com.bmf.api.flow;

import com.bmf.design.api.Result;
import com.bmf.design.api.flow.BusinessFlowQryService;
import com.bmf.design.api.flow.dto.BusinessFlowQryReqDTO;
import com.bmf.design.api.flow.dto.BusinessFlowRespDTO;
import com.bmf.design.base.flow.BusinessFlow;
import com.bmf.design.common.enums.ResultCodeEnum;
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
