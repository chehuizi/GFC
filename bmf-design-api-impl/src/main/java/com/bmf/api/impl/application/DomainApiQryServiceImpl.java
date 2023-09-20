package com.bmf.api.impl.application;

import com.bmf.api.Result;
import com.bmf.api.application.DomainApiQryService;
import com.bmf.api.application.dto.DomainApiQryReqDTO;
import com.bmf.api.application.dto.DomainApiRespDTO;
import com.bmf.base.application.DomainApi;
import com.bmf.base.application.DomainApp;
import com.bmf.common.utils.ResultUtil;
import com.bmf.core.application.DomainApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainApiQryServiceImpl implements DomainApiQryService {

    @Autowired
    private DomainApiService domainApiService;

    @Override
    public Result<DomainApiRespDTO> queryOne(DomainApiQryReqDTO req) {
        DomainApp domainApp = domainApiService.queryApp(req);
        List<DomainApi> domainApiList = domainApiService.queryApi(req);
        DomainApiRespDTO respDTO = new DomainApiRespDTO();
        respDTO.setDomainApp(domainApp);
        respDTO.setDomainApiList(domainApiList);
        return ResultUtil.success(respDTO);
    }
}
