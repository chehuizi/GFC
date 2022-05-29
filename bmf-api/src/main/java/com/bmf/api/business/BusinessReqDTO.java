package com.bmf.api.business;

import com.bmf.api.ReqDTO;
import com.bmf.base.Business;

import java.io.Serializable;

/**
 * 业务请求对象
 */
public class BusinessReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = 1324200904629702741L;

    /**
     * 业务
     */
    private Business business;
}
