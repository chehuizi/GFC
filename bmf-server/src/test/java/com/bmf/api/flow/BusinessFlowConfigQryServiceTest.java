package com.bmf.api.flow;

import com.bmf.common.api.Result;
import com.bmf.design.api.flow.BusinessFlowConfigQryService;
import com.bmf.design.api.flow.dto.BusinessFlowConfigQryReqDTO;
import com.bmf.design.api.flow.dto.BusinessFlowConfigRespDTO;
import com.bmf.design.model.flow.BusinessFlow;
import com.bmf.common.api.enums.ResultCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessFlowConfigQryServiceTest {

    @Autowired
    private BusinessFlowConfigQryService businessFlowQryService;

    @Test
    public void test_business_flow_query_one() {
        BusinessFlowConfigQryReqDTO qryReqDTO = new BusinessFlowConfigQryReqDTO();
        BusinessFlow businessFlow = BusinessFlow.builder()
                .businessCode(102)
                .flowId(1001)
                .build();
        qryReqDTO.setBusinessFlow(businessFlow);
        Result<BusinessFlowConfigRespDTO> result = businessFlowQryService.queryOne(qryReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

}
