package com.bmf.core.application;

import com.bmf.base.application.DomainApi;

import java.util.List;

/**
 * 业务API服务
 */
public interface BusinessApiService {

    /**
     * 批量创建业务API
     * @param domainApiList
     * @return
     */
    boolean createBusinessApi(List<DomainApi> domainApiList);
}
