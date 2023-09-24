package com.bmf.api.application;

import com.bmf.api.Result;
import com.bmf.api.application.dto.DomainApiQryReqDTO;
import com.bmf.api.application.dto.DomainApiRespDTO;
import com.bmf.common.enums.ResultCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainServiceQryServiceTest {

    @Autowired
    private DomainApiQryService domainApiQryService;

    @Test
    public void test_domain_api_query() {
        DomainApiQryReqDTO reqDTO = new DomainApiQryReqDTO();
        reqDTO.setDomainCode(101);
        Result<DomainApiRespDTO> result = domainApiQryService.queryOne(reqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }
}
