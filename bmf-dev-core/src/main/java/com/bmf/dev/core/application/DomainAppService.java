package com.bmf.dev.core.application;

import com.bmf.dev.api.application.dto.DomainAppCmdReqDTO;
import com.bmf.dev.api.application.dto.DomainAppQryReqDTO;
import com.bmf.dev.model.application.DomainApp;
import com.bmf.dev.model.application.DomainAppApi;

import java.util.List;

/**
 * 业务API服务
 */
public interface DomainAppService {

    /**
     * 创建API
     * @param req
     * @return
     */
    boolean createApi(DomainAppCmdReqDTO req);

    /**
     * 查询APP
     * @param req
     * @return
     */
    DomainApp queryApp(DomainAppQryReqDTO req);

    /**
     * 查询API
     * @param req
     * @return
     */
    List<DomainAppApi> queryApi(DomainAppQryReqDTO req);
}
