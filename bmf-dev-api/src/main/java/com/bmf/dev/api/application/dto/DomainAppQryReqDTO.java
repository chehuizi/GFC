package com.bmf.dev.api.application.dto;

import com.bmf.common.api.ReqDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * 业务API CMD请求对象
 */
@Data
public class DomainAppQryReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = 5040008711719634559L;

    /**
     * 领域编码
     */
    private Integer domainCode;
}
