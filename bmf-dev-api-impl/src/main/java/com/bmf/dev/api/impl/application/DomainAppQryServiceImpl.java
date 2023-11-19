package com.bmf.dev.api.impl.application;

import com.bmf.common.api.Result;
import com.bmf.common.api.utils.ResultUtil;
import com.bmf.dev.api.application.DomainAppQryService;
import com.bmf.dev.api.application.dto.DomainAppQryReqDTO;
import com.bmf.dev.api.application.dto.DomainAppRespDTO;
import com.bmf.dev.core.application.DomainAppService;
import com.bmf.dev.model.application.DomainApp;
import com.bmf.dev.model.application.DomainAppApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainAppQryServiceImpl implements DomainAppQryService {

    @Autowired
    private DomainAppService domainAppService;

    @Override
    public Result<DomainAppRespDTO> queryOne(DomainAppQryReqDTO req) {
        DomainApp domainApp = domainAppService.queryApp(req);
        List<DomainAppApi> domainAppApiList = domainAppService.queryApi(req);
        DomainAppRespDTO respDTO = new DomainAppRespDTO();
        respDTO.setDomainApp(domainApp);
        respDTO.setDomainAppApiList(domainAppApiList);
        return ResultUtil.success(respDTO);
    }
}
