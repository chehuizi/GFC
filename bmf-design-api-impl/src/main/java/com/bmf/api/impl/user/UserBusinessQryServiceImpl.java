package com.bmf.api.impl.user;

import com.bmf.api.Result;
import com.bmf.api.user.UserBusinessQryService;
import com.bmf.api.user.dto.UserBusinessQryReqDTO;
import com.bmf.api.user.dto.UserBusinessRespDTO;
import com.bmf.base.Business;
import com.bmf.base.user.UserBusiness;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.business.BusinessService;
import com.bmf.core.user.UserBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserBusinessQryServiceImpl implements UserBusinessQryService {

    @Autowired
    private UserBusinessService userBusinessService;
    @Autowired
    private BusinessService businessService;

    @Override
    @Validator(beanName = "userBusinessReqDTOValidator", method = "v4QueryOne")
    public Result<UserBusinessRespDTO> queryOne(UserBusinessQryReqDTO req) {
        List<UserBusiness> userBusinessList = userBusinessService.queryUserBusiness(req.getUserBusiness());
        if (Objects.isNull(userBusinessList) || userBusinessList.isEmpty()) {
            return ResultUtil.success(null);
        }
        List<Business> businessList = businessService.queryBusinessList(
                userBusinessList.stream().map(UserBusiness::getBusinessCode)
                        .collect(Collectors.toList()));
        return ResultUtil.success(new UserBusinessRespDTO(userBusinessList, businessList));
    }
}
