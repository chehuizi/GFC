package com.bmf.api.user.dto;

import com.bmf.api.RespDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.user.UserBusiness;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 用户业务返回对象
 */
@Data
@NoArgsConstructor
public class UserBusinessRespDTO extends RespDTO implements Serializable {

    /**
     * 用户业务
     */
    private UserBusiness userBusiness;
    /**
     * 用户业务列表
     */
    private List<UserBusiness> userBusinessList;

    public UserBusinessRespDTO(List<UserBusiness> userBusinessList) {
        this.userBusinessList = userBusinessList;
    }
}
