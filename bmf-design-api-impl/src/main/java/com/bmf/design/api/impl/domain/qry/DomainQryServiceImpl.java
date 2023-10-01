package com.bmf.design.api.impl.domain.qry;

import com.bmf.design.api.Result;
import com.bmf.design.api.domain.qry.DomainQryService;
import com.bmf.design.api.domain.dto.DomainQryReqDTO;
import com.bmf.design.api.domain.dto.DomainRespDTO;
import com.bmf.design.base.Domain;
import com.bmf.design.base.tactics.entity.DomainEntity;
import com.bmf.design.base.tactics.event.DomainEvent;
import com.bmf.design.common.utils.ResultUtil;
import com.bmf.design.common.validator.Validator;
import com.bmf.design.core.domain.DomainEntityService;
import com.bmf.design.core.domain.DomainEventService;
import com.bmf.design.core.domain.DomainService;
import com.bmf.design.core.domain.DomainServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DomainQryServiceImpl implements DomainQryService {

    @Autowired
    private DomainService domainService;
    @Autowired
    private DomainEntityService domainEntityService;
    @Autowired
    private DomainServiceService domainServiceService;
    @Autowired
    private DomainEventService domainEventService;

    @Override
    @Validator(beanName = "domainQryReqDTOValidator", method = "v4QueryOne")
    public Result<DomainRespDTO> queryOne(DomainQryReqDTO req) {
        Domain domain = domainService.queryDomain(req.getDomain());
        if (Objects.isNull(domain)) {
            return ResultUtil.success(null);
        }

        if (req.isIncludeEntity()) {
            List<DomainEntity> domainEntityList = domainEntityService.queryByDomainCode(domain.getDomainCode());
            domain.setDomainEntityList(domainEntityList);
        }
        if (req.isIncludeService()) {
            List<com.bmf.design.base.tactics.service.DomainService> domainServiceList = domainServiceService.queryByDomainCode(domain.getDomainCode());
            domain.setDomainServiceList(domainServiceList);
        }
        if (req.isIncludeEvent()) {
            List<DomainEvent> domainEventList = domainEventService.queryByDomainCode(domain.getDomainCode());
            domain.setDomainEventList(domainEventList);
        }
        return ResultUtil.success(new DomainRespDTO(domain));
    }

    @Override
    public Result<DomainRespDTO> queryByBusiness(DomainQryReqDTO domainQryReqDTO) {
        return null;
    }
}
