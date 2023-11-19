package com.bmf.dev.api.application.dto;

import com.bmf.common.api.RespDTO;
import com.bmf.dev.model.application.DomainApp;
import com.bmf.dev.model.application.DomainAppApi;
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
