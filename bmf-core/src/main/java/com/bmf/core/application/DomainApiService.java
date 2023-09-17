package com.bmf.core.application;

import com.bmf.api.application.dto.DomainApiCmdReqDTO;
import com.bmf.base.application.DomainApi;

import java.util.List;

/**
 * 业务API服务
 */
public interface DomainApiService {

    /**
     * 创建API
     * @param req
     * @return
     */
    boolean createApi(DomainApiCmdReqDTO req);
}
