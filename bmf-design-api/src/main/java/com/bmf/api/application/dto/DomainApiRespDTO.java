package com.bmf.api.application.dto;

import com.bmf.api.RespDTO;
import com.bmf.base.application.DomainApi;
import com.bmf.base.application.DomainApp;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 业务API服务返回对象
 */
@Data
public class DomainApiRespDTO extends RespDTO implements Serializable {

    private static final long serialVersionUID = 8552220429409857675L;

    private DomainApp domainApp;

    private List<DomainApi> domainApiList;
}
