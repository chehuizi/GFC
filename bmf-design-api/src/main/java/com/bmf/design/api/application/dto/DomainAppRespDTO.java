package com.bmf.design.api.application.dto;

import com.bmf.design.api.RespDTO;
import com.bmf.design.base.application.DomainAppApi;
import com.bmf.design.base.application.DomainApp;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 业务API服务返回对象
 */
@Data
public class DomainAppRespDTO extends RespDTO implements Serializable {

    private static final long serialVersionUID = 8552220429409857675L;

    private DomainApp domainApp;

    private List<DomainAppApi> domainAppApiList;
}
