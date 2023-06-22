package com.bmf.api.user;

import com.bmf.api.Result;
import com.bmf.api.user.dto.UserBusinessCmdReqDTO;
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
public class UserBusinessCmdServiceTest {

    @Autowired
    private UserBusinessCmdService userBusinessCmdService;

    @Test
    public void test_user_business_create() {
        UserBusinessCmdReqDTO userBusinessCmdReqDTO = new UserBusinessCmdReqDTO();
        UserBusiness userBusiness = new UserBusiness();
        userBusiness.setUserId(100001);
        userBusiness.setBusinessCode(101);
        userBusinessCmdReqDTO.setUserBusiness(userBusiness);
        Result<Boolean> result = userBusinessCmdService.create(userBusinessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }
}
