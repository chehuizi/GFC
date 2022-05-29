package com.bmf.api.domain;

import com.bmf.api.ReqDTO;
import com.bmf.base.BusinessDomain;
import lombok.Data;

import java.io.Serializable;

/**
 * 领域请求对象
 */
@Data
public class DomainReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = -8692914722346528072L;

    /**
     * 业务域
     */
    private BusinessDomain businessDomain;
}
