package com.bmf.core.application;

import com.bmf.base.application.BusinessApi;

import java.util.List;

/**
 * 业务API服务
 */
public interface BusinessApiService {

    /**
     * 批量创建业务API
     * @param businessApiList
     * @return
     */
    boolean createBusinessApi(List<BusinessApi> businessApiList);
}
