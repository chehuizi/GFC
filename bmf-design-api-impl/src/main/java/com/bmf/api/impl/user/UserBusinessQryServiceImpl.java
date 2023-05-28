package com.bmf.api.impl.user;

import com.bmf.api.Result;
import com.bmf.api.user.UserBusinessQryService;
import com.bmf.api.user.dto.UserBusinessQryReqDTO;
import com.bmf.api.user.dto.UserBusinessRespDTO;
import com.bmf.base.user.UserBusiness;
import com.bmf.common.utils.ResultUtil;
import com.bmf.core.user.UserBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserBusinessQryServiceImpl implements UserBusinessQryService {

    @Autowired
    private UserBusinessService userBusinessService;

    @Override
    public Result<UserBusinessRespDTO> queryOne(UserBusinessQryReqDTO req) {
        List<UserBusiness> userBusinessList = userBusinessService.queryUserBusiness(req.getUserBusiness());
        if (Objects.isNull(userBusinessList) || userBusinessList.isEmpty()) {
            return ResultUtil.success(null);
        }
        return ResultUtil.success(new UserBusinessRespDTO(userBusinessList));
    }
}
