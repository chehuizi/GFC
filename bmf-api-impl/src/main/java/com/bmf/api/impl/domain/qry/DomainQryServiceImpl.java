package com.bmf.api.impl.domain.qry;

import com.bmf.api.Result;
import com.bmf.api.domain.qry.DomainQryService;
import com.bmf.api.domain.dto.DomainQryReqDTO;
import com.bmf.api.domain.dto.DomainRespDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.domain.DomainEntityService;
import com.bmf.core.domain.DomainEventService;
import com.bmf.core.domain.DomainService;
import com.bmf.core.domain.DomainServiceService;
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
        BusinessDomain domain = domainService.queryDomain(req.getBusinessDomain());
        if (Objects.isNull(domain)) {
            return ResultUtil.success(null);
        }

        if (req.isIncludeEntity()) {
            List<DomainEntity> domainEntityList = domainEntityService.queryByDomainCode(domain.getDomainCode());
            domain.setDomainEntityList(domainEntityList);
        }
        if (req.isIncludeService()) {
            List<com.bmf.base.tactics.service.DomainService> domainServiceList = domainServiceService.queryByDomainCode(domain.getDomainCode());
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
