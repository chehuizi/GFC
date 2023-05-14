package com.bmf.api.user.dto;

import com.bmf.api.ReqDTO;
import com.bmf.base.user.User;
import com.bmf.base.user.UserBusiness;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户业务请求对象
 */
@Data
public class UserBusinessCmdReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = -6656240483808820077L;

    private UserBusiness userBusiness;
}
