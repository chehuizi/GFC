package com.bmf.api.user;

import com.bmf.common.api.Result;
import com.bmf.design.api.user.UserCmdService;
import com.bmf.design.api.user.dto.UserCmdReqDTO;
import com.bmf.design.model.user.User;
import com.bmf.common.api.enums.ResultCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCmdServiceTest {

    @Autowired
    private UserCmdService userCmdService;

    @Test
    public void test_user_create() {
        UserCmdReqDTO userCmdReqDTO = new UserCmdReqDTO();
        User user = new User();
        user.setUserName("chehuizi");
        user.setPassword("chehuizi");
        userCmdReqDTO.setUser(user);
        Result<Boolean> result = userCmdService.create(userCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }
}
