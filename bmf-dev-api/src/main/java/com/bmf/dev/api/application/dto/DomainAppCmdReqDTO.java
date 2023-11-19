package com.bmf.dev.api.application.dto;

import com.bmf.common.api.ReqDTO;
import com.bmf.dev.model.application.DomainApp;
import com.bmf.dev.model.application.DomainAppApi;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 业务API CMD请求对象
 */
@Data
public class DomainAppCmdReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = -1577850349100928700L;

    /**
     * app
     */
    private DomainApp domainApp;
    /**
     * API列表
     */
    private List<DomainAppApi> domainAppApiList;
}
