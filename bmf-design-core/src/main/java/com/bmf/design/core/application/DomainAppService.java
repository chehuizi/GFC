package com.bmf.design.core.application;

import com.bmf.design.api.application.dto.DomainAppCmdReqDTO;
import com.bmf.design.api.application.dto.DomainAppQryReqDTO;
import com.bmf.design.base.application.DomainAppApi;
import com.bmf.design.base.application.DomainApp;

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
