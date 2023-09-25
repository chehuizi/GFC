package com.bmf.api.impl.application;

import com.bmf.api.Result;
import com.bmf.api.application.DomainAppQryService;
import com.bmf.api.application.dto.DomainAppQryReqDTO;
import com.bmf.api.application.dto.DomainAppRespDTO;
import com.bmf.base.application.DomainAppApi;
import com.bmf.base.application.DomainApp;
import com.bmf.common.utils.ResultUtil;
import com.bmf.core.application.DomainAppService;
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
