package com.bmf.design.api.impl.user;

import com.bmf.design.api.Result;
import com.bmf.design.api.user.UserBusinessQryService;
import com.bmf.design.api.user.dto.UserBusinessQryReqDTO;
import com.bmf.design.api.user.dto.UserBusinessRespDTO;
import com.bmf.design.base.Business;
import com.bmf.design.base.user.User;
import com.bmf.design.base.user.UserBusiness;
import com.bmf.design.common.enums.BizCodeEnum;
import com.bmf.design.common.utils.BusinessCheckUtil;
import com.bmf.design.common.utils.ResultUtil;
import com.bmf.design.common.validator.Validator;
import com.bmf.design.core.business.BusinessService;
import com.bmf.design.core.user.UserBusinessService;
import com.bmf.design.core.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserBusinessQryServiceImpl implements UserBusinessQryService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserBusinessService userBusinessService;
    @Autowired
    private BusinessService businessService;

    @Override
    @Validator(beanName = "userBusinessReqDTOValidator", method = "v4QueryOne")
    public Result<UserBusinessRespDTO> queryOne(UserBusinessQryReqDTO req) {
        User user = userService.queryUser(new User(req.getUserBusiness().getUserId()));
        BusinessCheckUtil.checkNull(user, BizCodeEnum.USER_NOT_EXIST);
        List<UserBusiness> userBusinessList = userBusinessService.queryUserBusiness(req.getUserBusiness());
        if (Objects.isNull(userBusinessList) || userBusinessList.isEmpty()) {
            return ResultUtil.success(null);
        }
        List<Business> businessList = businessService.queryBusinessList(
                userBusinessList.stream().map(UserBusiness::getBusinessCode)
                        .collect(Collectors.toList()));
        BusinessCheckUtil.checkNull(businessList, BizCodeEnum.BUSINESS_NOT_EXIST);
        Map<Integer, Business> businessMap = businessList.stream().
                collect(Collectors.toMap(e -> e.getBusinessCode(), e -> e));
        for (UserBusiness item : userBusinessList) {
            item.setBusinessName(businessMap.get(item.getBusinessCode()).getBusinessName());
        }
        return ResultUtil.success(new UserBusinessRespDTO(userBusinessList, businessList));
    }
}
