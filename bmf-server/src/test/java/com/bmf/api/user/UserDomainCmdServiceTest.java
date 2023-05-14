package com.bmf.api.user;

import com.bmf.api.Result;
import com.bmf.api.user.dto.UserBusinessCmdReqDTO;
import com.bmf.api.user.dto.UserDomainCmdReqDTO;
import com.bmf.base.user.UserBusiness;
import com.bmf.base.user.UserDomain;
import com.bmf.common.enums.ResultCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDomainCmdServiceTest {

    @Autowired
    private UserDomainCmdService userDomainCmdService;

    @Test
    public void test_user_domain_create() {
        UserDomainCmdReqDTO userDomainCmdReqDTO = new UserDomainCmdReqDTO();
        UserDomain userDomain = new UserDomain();
        userDomain.setUserId(100003);
        userDomain.setDomainCode(101);
        userDomainCmdReqDTO.setUserDomain(userDomain);
        Result<Boolean> result = userDomainCmdService.create(userDomainCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }
}
