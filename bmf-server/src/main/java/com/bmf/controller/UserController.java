package com.bmf.controller;

import com.alibaba.fastjson.JSON;
import com.bmf.api.Result;
import com.bmf.api.user.UserBusinessQryService;
import com.bmf.api.user.dto.UserBusinessQryReqDTO;
import com.bmf.api.user.dto.UserBusinessRespDTO;
import com.bmf.base.user.UserBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserBusinessQryService userBusinessQryService;

    @GetMapping("business/detail")
    public String detail(@RequestParam("user_id") Integer userId) {
        UserBusinessQryReqDTO userBusinessQryReqDTO = new UserBusinessQryReqDTO();
        UserBusiness userBusiness = new UserBusiness();
        userBusiness.setUserId(userId);
        userBusinessQryReqDTO.setUserBusiness(userBusiness);
        Result<UserBusinessRespDTO> result = userBusinessQryService.queryOne(userBusinessQryReqDTO);
        return JSON.toJSONString(result);
    }

}
