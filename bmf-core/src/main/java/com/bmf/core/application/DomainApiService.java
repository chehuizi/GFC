package com.bmf.core.application;

import com.bmf.api.application.dto.DomainApiCmdReqDTO;
import com.bmf.api.application.dto.DomainApiQryReqDTO;
import com.bmf.base.application.DomainApi;
import com.bmf.base.application.DomainApp;

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

    /**
     * 查询APP
     * @param req
     * @return
     */
    DomainApp queryApp(DomainApiQryReqDTO req);

    /**
     * 查询API
     * @param req
     * @return
     */
    List<DomainApi> queryApi(DomainApiQryReqDTO req);
}
