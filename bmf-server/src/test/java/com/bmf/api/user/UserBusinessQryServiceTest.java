package com.bmf.api.user;

import com.bmf.api.Result;
import com.bmf.api.user.dto.UserBusinessQryReqDTO;
import com.bmf.api.user.dto.UserBusinessRespDTO;
import com.bmf.api.user.dto.UserCmdReqDTO;
import com.bmf.base.user.User;
import com.bmf.base.user.UserBusiness;
import com.bmf.common.enums.ResultCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBusinessQryServiceTest {

    @Autowired
    private UserBusinessQryService userBusinessQryService;

    @Test
    public void test_user_business_query() {
        UserBusinessQryReqDTO userBusinessQryReqDTO = new UserBusinessQryReqDTO();
        UserBusiness userBusiness = new UserBusiness();
        userBusiness.setUserId(100003);
        userBusinessQryReqDTO.setUserBusiness(userBusiness);
        Result<UserBusinessRespDTO> result = userBusinessQryService.queryOne(userBusinessQryReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }
}
