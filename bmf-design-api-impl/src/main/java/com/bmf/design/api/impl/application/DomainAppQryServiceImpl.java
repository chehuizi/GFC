package com.bmf.design.api.impl.application;

import com.bmf.design.api.Result;
import com.bmf.design.api.application.DomainAppQryService;
import com.bmf.design.api.application.dto.DomainAppQryReqDTO;
import com.bmf.design.api.application.dto.DomainAppRespDTO;
import com.bmf.design.base.application.DomainAppApi;
import com.bmf.design.base.application.DomainApp;
import com.bmf.design.common.utils.ResultUtil;
import com.bmf.design.core.application.DomainAppService;
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
