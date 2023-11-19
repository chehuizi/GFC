package com.bmf.design.api.user.dto;

import com.bmf.common.api.ReqDTO;
import com.bmf.design.model.user.UserBusiness;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户业务请求对象
 */
@Data
public class UserBusinessQryReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = -6656240483808820077L;

    private UserBusiness userBusiness;
}
